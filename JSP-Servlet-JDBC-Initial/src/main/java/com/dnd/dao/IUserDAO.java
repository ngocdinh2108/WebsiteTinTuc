package com.dnd.dao;

import com.dnd.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUsernameAndPasswordAndStatus(String userName, String password, Integer status);
}
