package com.dnd.paging;

import com.dnd.sort.Sorter;

public interface Pageble {
	Integer getPage();

	Integer getOffset();

	Integer getLimit();
	
	Sorter getSorter();
}
