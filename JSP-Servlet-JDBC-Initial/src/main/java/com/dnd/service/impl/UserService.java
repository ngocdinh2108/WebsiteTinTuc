package com.dnd.service.impl;

import javax.inject.Inject;

import com.dnd.dao.IUserDAO;
import com.dnd.model.UserModel;
import com.dnd.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUsernameAndPasswordAndStatus(userName, password, status);
	}

}
