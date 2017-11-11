package com.practice.orm.hibernate.simpleprogrammer.model;

public class ProteinData {

	private int total;
	private int goal;
	
	/**One to Many: Bi Directional- Making Entry**/
	private int id;
	/**One to Many: Bi Directional**/
	private User user;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	@Override
	public String toString() {
		return "ProteinData [total=" + total + ", goal=" + goal + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
