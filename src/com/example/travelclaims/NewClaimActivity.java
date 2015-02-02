//source from http://www.truiton.com/2013/03/android-pick-date-time-from-edittext-onclick-event/ -- Jan 27, 2015

package com.example.travelclaims;
 
import java.util.Calendar;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class NewClaimActivity extends FragmentActivity {
	
	private static EditText StartDateEdit;
	private static EditText EndDateEdit;
	private static boolean Start;
 
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
		
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.addnewclaim);
		 
		 StartDateEdit = (EditText) findViewById(R.id.editStartDate);
		 EndDateEdit = (EditText) findViewById(R.id.editEndDate);
		 
		 if (MainActivity.edit) {
			 ClaimList cl = new ClaimList();
			 cl.removeClaim(MainActivity.claim);
			 EditText Destination = (EditText) findViewById(R.id.editDestination);
			 EditText Description = (EditText) findViewById(R.id.description);
			 Destination.setText(MainActivity.claim.getClaim(), TextView.BufferType.EDITABLE);
			 StartDateEdit.setText(MainActivity.claim.getStartDate(), TextView.BufferType.EDITABLE);
			 EndDateEdit.setText(MainActivity.claim.getEndDate(), TextView.BufferType.EDITABLE);
			 Description.setText(MainActivity.claim.getDescription(), TextView.BufferType.EDITABLE);
		 }
		 set_on_click();
	}
 
	public void showTruitonDatePickerDialog(View v) {
		
		if (v == StartDateEdit) {
			Start = true;
		} else {
			Start = false;
		}
		
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
			// Do something with the date chosen by the user
			if (Start) {
				StartDateEdit.setText(day + "/" + (month + 1) + "/" + year);
			} else {
				EndDateEdit.setText(day + "/" + (month + 1) + "/" + year);
			}
		}
	}
	
	private void set_on_click() {
		StartDateEdit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showTruitonDatePickerDialog(v);
			}
			});
		EndDateEdit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showTruitonDatePickerDialog(v);
			}
			});
	}
	
	public void addClaim(View v) {
		Toast.makeText(this, "Adding a Claim", Toast.LENGTH_SHORT).show();
		ClaimList cl = new ClaimList();
		EditText claimView = (EditText) findViewById(R.id.editDestination);
		EditText StartDateView = (EditText) findViewById(R.id.editStartDate);
		EditText EndDateView = (EditText) findViewById(R.id.editEndDate);
		EditText description = (EditText) findViewById(R.id.description);
		cl.addClaim(new Claim(claimView.getText().toString(), StartDateView.getText().toString(), EndDateView.getText().toString(),
						description.getText().toString()));
		Intent intent = new Intent(NewClaimActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
		return true;
	}
	
	public void goBack(MenuItem menu) {
		Intent intent = new Intent(NewClaimActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}

