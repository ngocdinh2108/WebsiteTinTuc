package com.dnd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dnd.model.RoleModel;
import com.dnd.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel userModel = new UserModel();
		try {
			userModel.setId(resultSet.getLong("id"));
			userModel.setUserName(resultSet.getString("username"));
			userModel.setPassword(resultSet.getString("password"));
			userModel.setFullName(resultSet.getString("fullname"));
			userModel.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				userModel.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			//userModel.setRoleId(resultSet.getLong("roleid"));
			userModel.setCreatedBy(resultSet.getString("createdby"));
			userModel.setModifiedBy(resultSet.getString("modifiedby"));
			userModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			userModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			return userModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
