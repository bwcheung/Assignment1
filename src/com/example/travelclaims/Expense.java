package com.example.travelclaims;

public class Expense {
	
	protected int cost;
	protected String Date;
	protected String category;
	protected String currency;
	protected String description;
	
	public Expense(int cost, String Date, String category, String currency, String description) {
		this.cost = cost;
		this.Date = Date;
		this.category = category;
		this.currency = currency;
		this.description = description;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public String getDate() {
		return this.Date;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
}
