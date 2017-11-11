package com.practice.orm.hibernate.simpleprogrammer.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class AuditInerceptor extends EmptyInterceptor{

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		
		System.out.println("Saving an Entity!");
		return false;
	}

	@Override
	public void postFlush(Iterator entities) {
		System.out.println("After entity has been flushed!");
	}



}
