package com.practice.nosql.gemfire.events.server.dao;

import com.practice.nosql.gemfire.model.BookMaster;

public interface BookMasterDao {

	BookMaster getBookMaster(int itemNumber);
}
