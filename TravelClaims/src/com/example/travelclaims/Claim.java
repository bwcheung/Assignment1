package com.example.travelclaims;

import java.util.ArrayList;

public class Claim {
	
	protected String claim;
	protected String startdate;
	protected String enddate;
	protected String status;
	protected String description;
	protected ArrayList<Expense> expenselist;
	
	public Claim(String claim, String startdate, String enddate, String description) {
		this.claim = claim;
		this.startdate = startdate;
		this.enddate = enddate;
		this.description = description;
		this.status = "In Progress";
		this.expenselist = new ArrayList<Expense>();
	}
	
	public String getClaim() {
		return this.claim;
	}
	
	public String getDateRange() {
		return this.startdate + "-" + this.enddate;
	}
	
	public String getStartDate() {
		return this.startdate;
	}
	
	public String getEndDate() {
		return this.enddate;
	}
	public String getStatus() {
		return this.status;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public ArrayList<Expense> getExpenses() {
		return this.expenselist;
	}
	
	public void addExpense(Expense expense) {
		expenselist.add(expense);
	}
}
