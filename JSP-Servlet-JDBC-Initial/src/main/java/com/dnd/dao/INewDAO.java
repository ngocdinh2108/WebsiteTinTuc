package com.dnd.dao;

import java.util.List;

import com.dnd.model.NewModel;
import com.dnd.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel updateNew);

	void delele(long id);

	NewModel findOne(long id);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
