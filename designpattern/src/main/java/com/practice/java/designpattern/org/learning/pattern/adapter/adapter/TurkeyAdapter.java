package com.practice.java.designpattern.org.learning.pattern.adapter.adapter;

import com.practice.java.designpattern.org.learning.pattern.adapter.adaptee.Turkey;
import com.practice.java.designpattern.org.learning.pattern.adapter.target.Duck;

public class TurkeyAdapter implements Duck {
	Turkey turkey;
 
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
    
	public void quack() {
		turkey.gobble();
	}
  
	public void fly() {
		for(int i=0; i < 5; i++) {
			turkey.fly();
		}
	}
}
