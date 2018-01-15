package com.practice.java.designpattern.org.learning.pattern.adapter.javaapi;

import java.util.*;

public class EI {
	public static void main (String args[]) {
		Vector v = new Vector(Arrays.asList("a","b","c"));
		Enumeration enumeration = v.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		Iterator iterator = v.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
