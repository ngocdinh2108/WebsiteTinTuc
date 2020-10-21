package com.dnd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dnd.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setId(resultSet.getLong("id"));
			categoryModel.setName(resultSet.getString("name"));
			categoryModel.setCode(resultSet.getString("code"));
			return categoryModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
