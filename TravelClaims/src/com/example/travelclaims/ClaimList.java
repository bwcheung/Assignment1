package com.example.travelclaims;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimList {
	
	protected ArrayList<Claims> claimslist;
	
	public ClaimList() {
		claimslist = new ArrayList<Claims>();
	}

	public Collection<Claims> getClaims() {
		return claimslist;
	}
	
	public void addClaim(Claims claim) {
		claimslist.add(claim);
	}
	
	public void removeClaim(Claims claim) {
		claimslist.remove(claim);
	}
	
}
