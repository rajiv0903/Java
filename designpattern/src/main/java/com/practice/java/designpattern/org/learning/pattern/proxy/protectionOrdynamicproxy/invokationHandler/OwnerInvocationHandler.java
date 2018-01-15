package com.practice.java.designpattern.org.learning.pattern.proxy.protectionOrdynamicproxy.invokationHandler;
 
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.practice.java.designpattern.org.learning.pattern.proxy.protectionOrdynamicproxy.realSubject.PersonBean;
 
public class OwnerInvocationHandler implements InvocationHandler { 
	PersonBean person;
 
	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}
 
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {
  
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
   			} else if (method.getName().equals("setHotOrNotRating")) {
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				return method.invoke(person, args);
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}
