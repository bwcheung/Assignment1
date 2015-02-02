package com.example.travelclaims;

import java.util.ArrayList;

public class ClaimList {
	
	protected static ArrayList<Claim> claimslist;
	
	public ArrayList<Claim> getClaimList() {
		if (claimslist == null) {
			claimslist = new ArrayList<Claim>();
		}
		return claimslist;
	}
	
	public void addClaim(Claim claim) {
		claimslist.add(claim);
	}
	
	public void removeClaim(Claim claim) {
		claimslist.remove(claim);
	}
	
}
