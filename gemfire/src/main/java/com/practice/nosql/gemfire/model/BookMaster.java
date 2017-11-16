package com.practice.nosql.gemfire.model;

import java.io.Serializable;

public class BookMaster implements Serializable{

	private static final long serialVersionUID = 5L;
	
	private int itemNumber;
	private String title;
	private String description;
	private float retailCost;
	private int yearPublished;
	private String author;
	
	public BookMaster() {}
	
	
	public BookMaster(int itemNumber, String title, String description, float retailCost, int yearPublished,
			String author) {
		super();
		this.itemNumber = itemNumber;
		this.title = title;
		this.description = description;
		this.retailCost = retailCost;
		this.yearPublished = yearPublished;
		this.author = author;
	}


	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getRetailCost() {
		return retailCost;
	}
	public void setRetailCost(float retailCost) {
		this.retailCost = retailCost;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookMaster [itemNumber=" + itemNumber + ", title=" + title + ", description=" + description
				+ ", retailCost=" + retailCost + ", yearPublished=" + yearPublished + ", author=" + author + "]";
	}
	
	
	
	

}
