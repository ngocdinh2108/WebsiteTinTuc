package com.dnd.service;

import com.dnd.model.UserModel;

public interface IUserService {
	UserModel findByUsernameAndPasswordAndStatus(String userName, String password, Integer status);
}
