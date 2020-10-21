package com.dnd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dnd.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		NewModel newModel = new NewModel();
		try {
			newModel.setId(resultSet.getLong("id"));
			newModel.setTitle(resultSet.getString("title"));
			newModel.setThumbnail(resultSet.getString("thumbnail"));
			newModel.setShortDescription(resultSet.getString("shortdescription"));
			newModel.setCategoryId(resultSet.getLong("categoryid"));
			newModel.setContent(resultSet.getString("content"));
			newModel.setCreatedBy(resultSet.getString("createdby"));
			newModel.setModifiedBy(resultSet.getString("modifiedby"));
			newModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			newModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			return newModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
