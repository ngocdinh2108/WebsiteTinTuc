package com.dnd.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnd.constant.SystemConstant;
import com.dnd.model.NewModel;
import com.dnd.paging.PageRequest;
import com.dnd.paging.Pageble;
import com.dnd.service.ICategoryService;
import com.dnd.service.INewService;
import com.dnd.sort.Sorter;
import com.dnd.util.FormUtil;

@WebServlet(urlPatterns = "/admin-new")
public class NewController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;
	
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newService.findAll(pageble));
			model.setTotalItem(newService.getTotalItem());
			int totalPage = model.getTotalItem() / model.getMaxPageItem()
					+ (model.getTotalItem() % model.getMaxPageItem() == 0 ? 0 : 1);
			model.setTotalPage(totalPage);
			if(request.getParameter("message")!=null) {
				request.setAttribute("message","");
				request.setAttribute("alert", "");
			}
			view = "/views/admin/new/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = newService.findOne(model.getId());
			}
			request.setAttribute("message","");
			request.setAttribute("alert", "");
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/new/edit.jsp";
		}
		if(request.getParameter("message")!=null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if(message.equals("insert_success")) {
				messageResponse = "Insert Succcess";
				alert = "success";
			}
			else if (message.equals("update_success")) {
				messageResponse = "Update Succcess";
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete Succcess";
				alert = "success";
			} else if (message.equals("error_system")) {
				messageResponse = "Error System";
				alert = "danger";
			}
			request.setAttribute("messageResponse",messageResponse);
			request.setAttribute("alert", alert);
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
		requestDispatcher.forward(request, response);
	}

}