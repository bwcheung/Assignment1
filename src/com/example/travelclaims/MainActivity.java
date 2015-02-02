/* Assignment 1: TravelClaim
 * Name: Brandon Cheung
 * CCID: bwcheung
 * Date: Feb 2, 2015
 * LICENSE: APACHE 2.0 (read the Readme file)
 * Description: This activity is the main activity that shows the home page which will show the claim list. This activity handles
 * on click event of each claims, which will go to the claim summary page. This activity also handles a context menu that will
 * allow user to on long click edit, delete, change status, and email a claim. This is an incomplete code. Emailing and changing
 * status is not covered
 */
package com.example.travelclaims;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	public static Claim claim;
	public ListView lv1;
	public ClaimList cl = new ClaimList();
	public static boolean edit = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayList<Claim> claimslist = cl.getClaimList();
		final ListView lv1 = (ListView) findViewById(R.id.Claimlist);
		CustomBaseAdapter adapter = new CustomBaseAdapter(this, claimslist);
		lv1.setAdapter(adapter);
		registerForContextMenu(lv1);
		
		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				
				claim = (Claim) lv1.getItemAtPosition(position);
				Intent intent = new Intent(MainActivity.this, ClaimSummaryActivity.class);
				startActivity(intent);
			}
        });
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		String[] menuItems = getResources().getStringArray(R.array.menu_array);
		for (int i = 0; i<menuItems.length; i++) {
			menu.add(Menu.NONE, i, i, menuItems[i]);
		}
	}
	
	 @Override
	 public boolean onContextItemSelected(MenuItem item) {
		 
		 final ListView lv1 = (ListView) findViewById(R.id.Claimlist);
		 AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		 int menuItemIndex = item.getItemId();
		 String[] menuItems = getResources().getStringArray(R.array.menu_array);
		 String menuItemName = menuItems[menuItemIndex];
		 
		 claim = (Claim) lv1.getItemAtPosition(info.position);
		 ArrayList<Claim> claimslist = cl.getClaimList();
		 
		 if (menuItemName.equals("Delete")) {
			 claimslist.remove(claim);
			 finish();
			 startActivity(getIntent());
		 } else if (menuItemName.equals("Edit")) {
			 if (claim.getStatus().equals("submitted") || (claim.getStatus().equals("approved"))) {
				 Toast.makeText(this, "Cannot Edit Claim", Toast.LENGTH_SHORT).show();
			 } else {
				 edit = true;
				 Intent intent = new Intent(MainActivity.this, NewClaimActivity.class);
				 startActivity(intent);
			 }
		 } else if (menuItemName.equals("Change Status")) {
			  //Does not have a change status function
		 } else if (menuItemName.equals("Email")) {
			  //Does not have a email function
		 }
		 
		
		 return true;
	 }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void newclaim(MenuItem menu) {
		Intent intent = new Intent(MainActivity.this, NewClaimActivity.class);
		startActivity(intent);
		finish();
	}
}

