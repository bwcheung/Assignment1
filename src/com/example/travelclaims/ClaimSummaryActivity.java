/* Assignment 1: TravelClaim
 * Name: Brandon Cheung
 * CCID: bwcheung
 * Date: Feb 2, 2015
 * LICENSE: APACHE 2.0 (read the Readme file)
 * Description: This activity shows my claim summary layout, which is a screen that shows the information of the claim like expenses.
 * This activity also handles context menu which is when a user holds click on one of the expense item in the list, a menu will appear.
 * This is an imcomplete code. It does not handle editing a claim.
 */
package com.example.travelclaims;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ClaimSummaryActivity extends Activity {
	
	public int totalCAD = 0;
	public int totalUSD = 0;
	public int totalEUR = 0;
	public int totalGBP = 0;
	
	public ListView lv2;
	public ArrayList<Expense> expenseList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.claimsummary);
		
		expenseList = MainActivity.claim.getExpenses();
		
		TextView desText = (TextView) findViewById(R.id.textdescription);
		TextView title = (TextView) findViewById(R.id.titles);
		TextView CADcost = (TextView) findViewById(R.id.CADcost);
		TextView USDcost = (TextView) findViewById(R.id.USDcost);
		TextView EURcost = (TextView) findViewById(R.id.EURcost);
		TextView GBPcost = (TextView) findViewById(R.id.GBPcost);
		
		final ListView lv1 = (ListView) findViewById(R.id.expenselist);
		CustomExpenseListAdapter adapter = new CustomExpenseListAdapter(this, expenseList);
		lv1.setAdapter(adapter);

		title.setText(MainActivity.claim.getClaim());
		desText.setText(MainActivity.claim.getDescription());
		if (expenseList == null) {
			CADcost.setText("0");
			USDcost.setText("0");
			EURcost.setText("0");
			GBPcost.setText("0");
		} else {
			for (int i = 0; i < expenseList.size(); i++) {
				
				String currency = expenseList.get(i).getCurrency();
				int cost = expenseList.get(i).getCost();
				
				if (currency.equals("CAD")) {
					totalCAD = totalCAD + cost;
				} else if (currency.equals("USD")) {
					totalUSD = totalUSD + cost;
				} else if (currency.equals("EUR")) {
					totalEUR = totalEUR + cost;
				} else {
					totalGBP = totalGBP + cost;
				}
			}
			CADcost.setText(String.valueOf(totalCAD));
			USDcost.setText(String.valueOf(totalUSD));
			EURcost.setText(String.valueOf(totalEUR));
			GBPcost.setText(String.valueOf(totalGBP));
		}
		registerForContextMenu(lv1);
	}
	
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		String[] menuItems = getResources().getStringArray(R.array.expenseMenuArray);
		for (int i = 0; i<menuItems.length; i++) {
			menu.add(Menu.NONE, i, i, menuItems[i]);
		}
	}
	
	 @Override
	 public boolean onContextItemSelected(MenuItem item) {
		 
		 final ListView lv1 = (ListView) findViewById(R.id.expenselist);
		 AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		 int menuItemIndex = item.getItemId();
		 String[] menuItems = getResources().getStringArray(R.array.expenseMenuArray);
		 String menuItemName = menuItems[menuItemIndex];
		 Expense expense = (Expense) lv1.getItemAtPosition(info.position);
		 
		 if (menuItemName.equals("Delete")) {
			 expenseList.remove(expense);
			 finish();
			 startActivity(getIntent());
		 } else if (menuItemName.equals("Edit")) {
			 //Does not have a Edit expense function
		 }

		 return true;
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.claim_summary, menu);
		return true;
	}
	
	public void newExpense(MenuItem menu) {
		Intent intent = new Intent(ClaimSummaryActivity.this, NewExpenseActivity.class);
		startActivity(intent);
		finish();
	}
}
