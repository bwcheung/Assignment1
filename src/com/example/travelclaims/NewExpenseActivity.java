/* Assignment 1: TravelClaim
 * Name: Brandon Cheung
 * CCID: bwcheung
 * Date: Feb 2, 2015
 * LICENSE: APACHE 2.0 (read the Readme file)
 * Source taken from: http://developer.android.com/guide/topics/ui/controls/spinner.html, http://stackoverflow.com/questions/1947933/how-to-get-spinner-value
 * Description: This activity handles adding a new claim. This activity uses spinners to allow the user to pick a category and currency. 
 * It then gets these values and add them into the expense list along with other user inputs.
 */
package com.example.travelclaims;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewExpenseActivity extends FragmentActivity {

	private static EditText DateView;
	public static ArrayList<String> categorylist;
	private EditText description;
	private EditText cost;
	private EditText expense; 
	public String category;
	public String currency;
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addnewexpense);
		
		DateView = (EditText) findViewById(R.id.editDate);
		
		final Spinner categoryspinner = (Spinner) findViewById(R.id.categoryspinner);
		ArrayAdapter<CharSequence> categoryadapter = ArrayAdapter.createFromResource(this,
		        R.array.category_array, android.R.layout.simple_spinner_item);
		categoryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categoryspinner.setAdapter(categoryadapter);
		
		final Spinner currencyspinner = (Spinner) findViewById(R.id.currencyspinner);
		ArrayAdapter<CharSequence> currencyadapter = ArrayAdapter.createFromResource(this,
		        R.array.currency_array, android.R.layout.simple_spinner_item);
		currencyadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		currencyspinner.setAdapter(currencyadapter);
		
		currencyspinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
            	currency = currencyspinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
		categoryspinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
            	category = categoryspinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
		
		set_on_click();
		
	}
	
	public void showTruitonDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "datePicker");
	}
 
	public static class DatePickerFragment extends DialogFragment
    				implements DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			
			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {
			DateView.setText(day + "/" + (month + 1) + "/" + year);
		}
	}
	
	private void set_on_click() {
		DateView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showTruitonDatePickerDialog(v);
			}
			});
	}
	
	public void addExpense(View v) {
		Toast.makeText(this, "Adding Expense", Toast.LENGTH_SHORT).show();
		description = (EditText) findViewById(R.id.editDescription2);
		cost = (EditText) findViewById(R.id.editCost);
		expense = (EditText) findViewById(R.id.expense);
		Claim claim = MainActivity.claim;
		claim.addExpense(new Expense(Integer.parseInt(cost.getText().toString()), DateView.getText().toString(), 
				category.toString(), currency.toString(), description.getText().toString(), expense.getText().toString()));
		Intent intent = new Intent(NewExpenseActivity.this, ClaimSummaryActivity.class);
		startActivity(intent);
		finish();
	}
}
