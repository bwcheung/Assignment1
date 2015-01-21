package com.example.travelclaims;

import java.sql.Date;

public class Claims {
	
	protected String Claim;
	protected Date date;
	protected String Status;
	
	public Claims(String Claim, Date date, String Status) {
		this.Claim = Claim;
		this.date = date;
		this.Status = Status;
	}
	
	public String getClaim() {
		return this.Claim;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getStatus() {
		return this.Status;
	}
}
