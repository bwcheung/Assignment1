/* Assignment 1: TravelClaim
 * Name: Brandon Cheung
 * CCID: bwcheung
 * Date: Feb 2, 2015
 * LICENSE: APACHE 2.0 (read the Readme file)
 * Source taken from: http://www.androidhive.info/2012/02/android-custom-listview-with-image-and-text/ -- Jan 31, 2015
 * Description: This is a custom adapter that lets me show my expenses in a custom listview. This is a incomplete code.
 * Right now this will only handle showing the name of the expense and will not show anything else in the list like cost
 * of each expense.
 */
package com.example.travelclaims;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomExpenseListAdapter extends BaseAdapter {
	
	private static ArrayList<Expense> ExpenseList;
	
	private LayoutInflater mInflater;
	
	public CustomExpenseListAdapter(Context context, ArrayList<Expense> expenselist) {
		ExpenseList = expenselist;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return ExpenseList.size();
	}

	public Object getItem(int position) {
		return ExpenseList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	@SuppressLint("InflateParams")
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.customexpenselist, null);
			holder = new ViewHolder();
			holder.expense = (TextView) convertView.findViewById(R.id.Expense);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.expense.setText(ExpenseList.get(position).getExpense());
		
		return convertView;
	}

	static class ViewHolder {
		TextView expense;
	
	}

}
