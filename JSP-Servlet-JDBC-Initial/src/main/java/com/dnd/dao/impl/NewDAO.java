package com.dnd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.dnd.dao.INewDAO;
import com.dnd.mapper.NewMapper;
import com.dnd.model.NewModel;
import com.dnd.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "INSERT INTO news (title,content,categoryid,thumbnail,shortdescription,createddate,createdby) VALUES (?,?,?,?,?,?,?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId(),
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCreatedDate(),
				newModel.getCreatedBy());
	}

	@Override
	public NewModel findOne(long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		String sql = "UPDATE news SET title = ?, content = ?, thumbnail = ?, shortdescription = ?, categoryid = ?, createdby = ?, createddate = ?, modifieddate = ?, modifiedby = ? WHERE id = ?";
		update(sql, updateNew.getTitle(), updateNew.getContent(), updateNew.getThumbnail(),
				updateNew.getShortDescription(), updateNew.getCategoryId(), updateNew.getCreatedBy(),
				updateNew.getCreatedDate(), updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());

	}

	@Override
	public void delele(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT ?, ?");
			return query(sql.toString(), new NewMapper(), pageble.getOffset(), pageble.getLimit());
		}
		return query(sql.toString(), new NewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

}
