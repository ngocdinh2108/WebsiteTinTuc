package com.dnd.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dnd.dao.ICategoryDAO;
import com.dnd.model.CategoryModel;
import com.dnd.service.ICategoryService;

public class CategoryService implements ICategoryService {

	// servlet weld. khoi tao doi tuong ma k can new doi tuong
	@Inject
	private ICategoryDAO categoryDAO;
	
//	public CategoryService() {
//		categoryDAO = new CategoryDAO();
//	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}
