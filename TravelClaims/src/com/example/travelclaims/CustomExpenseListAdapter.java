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
			holder.cost = (TextView) convertView.findViewById(R.id.customcost);
			holder.category = (TextView) convertView.findViewById(R.id.customcategory);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.cost.setText(ExpenseList.get(position).getCost());
		holder.category.setText(ExpenseList.get(position).getCategory());
		
		return convertView;
	}

	static class ViewHolder {
		TextView cost;
		TextView category;
	}

}
