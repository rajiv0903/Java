package com.practice.orm.hibernate.simpleprogrammer.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private int id;
	private String name;
	
	/**Start: Data Type**/
	private long primaryId;
	private short surogateId;
	private float amount;
	private double paid;
	private char active;
	private boolean proteinTaker;
	/**End: Data Type**/
	
	/** Value Mapping Component**/
	/*private ProteinData proteinData = new ProteinData();*/
	
	/** Value Mapping **/
	/*private Set<UserHistory> userHistory = new HashSet<>();*/
	/*private List<UserHistory> userHistory = new ArrayList<>();*/
	/*private Map<String, UserHistory> userHistory = new HashMap<>();*/
	/*private Collection<UserHistory> userHistory = new ArrayList<>();*/
	
	/**Start: Entity Mapping: One to Many**/
	private List<UserHistory> userHistory = new ArrayList<>();
	/** End :Entity Mapping: One to Many**/
	
	/**Start: Entity Mapping: One to One**/
	private ProteinData proteinData;
	public User() {
		setProteinData(new ProteinData());
	}
	/**End: Entity Mapping: One to One**/
	
	/**Start:  Joining Table: One to One **/
	//private GoalAlert goalAlert;
	/**End:  Joining Table: One to One **/
	
	/** Joining Table: One to Many **/
	private Set<GoalAlert> goalAlerts = new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		/**One to One : Bi Directional **/
		proteinData.setUser(this);
	}

	public List<UserHistory> getUserHistory() {
		return userHistory;
	}
	public void setUserHistory(List<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}
	/**
	 * One to Many 
	 */
	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		userHistory.add(historyItem);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", proteinData=" + proteinData + ", userHistory=" + userHistory
				+ "]";
	}
	public Set<GoalAlert> getGoalAlerts() {
		return goalAlerts;
	}
	public void setGoalAlerts(Set<GoalAlert> goalAlert) {
		this.goalAlerts = goalAlert;
	}
	public long getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(long primaryId) {
		this.primaryId = primaryId;
	}
	public short getSurogateId() {
		return surogateId;
	}
	public void setSurogateId(short surogateId) {
		this.surogateId = surogateId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public double getPaid() {
		return paid;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	public char getActive() {
		return active;
	}
	public void setActive(char active) {
		this.active = active;
	}
	public boolean isProteinTaker() {
		return proteinTaker;
	}
	public void setProteinTaker(boolean proteinTaker) {
		this.proteinTaker = proteinTaker;
	}

	
	
	
	
}
