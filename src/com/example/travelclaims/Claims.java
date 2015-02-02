package com.example.travelclaims;

import java.sql.Date;

public class Claims {
	
	protected String Claim;
	protected Date startdate;
	protected Date enddate;
	protected String Status;
	
	public Claims(String Claim, Date startdate, Date enddate, String Status) {
		this.Claim = Claim;
		this.startdate = startdate;
		this.enddate = enddate;
		this.Status = Status;
	}
	
	public String getClaim() {
		return this.Claim;
	}
	
	public Date getstartDate() {
		return this.startdate;
	}
	
	public Date getendDate() {
		return this.enddate;
	}
	
	public String getStatus() {
		return this.Status;
	}
}
