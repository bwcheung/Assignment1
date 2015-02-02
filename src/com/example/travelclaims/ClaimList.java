/* Assignment 1: TravelClaim
 * Name: Brandon Cheung
 * CCID: bwcheung
 * Date: Feb 2, 2015
 * LICENSE: APACHE 2.0 (read the Readme file)
 * Description: This is the claimlist class that creates an ArrayList that contains the object claim.
 * This class handles the removing and adding claims from the list. 
 */
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
