package com.practice.java.designpattern.org.learning.pattern.state.gumballstate.state;

public interface State {
 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
