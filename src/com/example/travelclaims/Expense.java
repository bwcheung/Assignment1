/* Assignment 1: TravelClaim
 * Name: Brandon Cheung
 * CCID: bwcheung
 * Date: Feb 2, 2015
 * LICENSE: APACHE 2.0 (read the Readme file)
 * Description: This is the Expense class that creates an object called "expense" with the atrributes of cost, date, category, currency,
 * description and expense. This class will also return these attributes.
 */
package com.example.travelclaims;

public class Expense {
	
	protected int cost;
	protected String Date;
	protected String category;
	protected String currency;
	protected String description;
	protected String expense;
	
	public Expense(int cost, String Date, String category, String currency, String description, String expense) {
		this.cost = cost;
		this.Date = Date;
		this.category = category;
		this.currency = currency;
		this.expense = expense;
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
	
	public String getExpense() {
		return this.expense;
	}
	
}
