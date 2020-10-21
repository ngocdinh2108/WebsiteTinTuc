package com.dnd.service;

import java.util.List;

import com.dnd.model.NewModel;
import com.dnd.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);

	NewModel save(NewModel newModel);

	NewModel update(NewModel updateNew);

	void delete(long[] ids);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
	
	NewModel findOne(long id);
}
