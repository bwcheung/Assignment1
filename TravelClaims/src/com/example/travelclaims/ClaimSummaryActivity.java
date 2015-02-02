package com.example.travelclaims;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ClaimSummaryActivity extends Activity {
	
	public int totalCAD = 0;
	public int totalUSD = 0;
	public int totalEUR = 0;
	public int totalGBP = 0;
	public ListView lv2;
	public static ArrayList<Expense> expenseList;
	
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
		
		ListView lv1 = (ListView)findViewById(R.id.expenselist);
		ArrayAdapter<Expense> codeLearnArrayAdapter = new ArrayAdapter<Expense>(this, android.R.layout.simple_list_item_1, expenseList);
		lv1.setAdapter(codeLearnArrayAdapter);
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
					Toast.makeText(this, "CAD", Toast.LENGTH_SHORT).show();
					totalCAD = totalCAD + cost;
				} else if (currency.equals("USD")) {
					Toast.makeText(this, "USD", Toast.LENGTH_SHORT).show();
					totalUSD = totalUSD + cost;
				} else if (currency.equals("EUR")) {
					Toast.makeText(this, "EUR", Toast.LENGTH_SHORT).show();
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.claim_summary, menu);
		return true;
	}
	
	public void newExpense(MenuItem menu) {
		Intent intent = new Intent(ClaimSummaryActivity.this, NewExpenseActivity.class);
		startActivity(intent);
	}
}
