package com.practice.nosql.gemfire.events.server.listeners;

import java.util.Properties;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

import com.practice.nosql.gemfire.events.server.dao.BookMasterDao;
import com.practice.nosql.gemfire.events.server.dao.BookMasterDaoImpl;
import com.practice.nosql.gemfire.model.BookMaster;

public class BookMasterCacheLoader implements CacheLoader<Integer, BookMaster>, Declarable {

	private BookMasterDao dao;

	@Override
	public void close() {

	}

	@Override
	public BookMaster load(LoaderHelper<Integer, BookMaster> helper) throws CacheLoaderException {
		return dao.getBookMaster(helper.getKey());
	}

	@Override
	public void init(Properties props) {
		dao = new BookMasterDaoImpl(props.getProperty("driverClassName"), props.getProperty("url"),
				props.getProperty("userName"), props.getProperty("password"));
	}

}
