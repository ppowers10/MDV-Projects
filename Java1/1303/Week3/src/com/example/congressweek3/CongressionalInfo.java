/*
 * 	project		CongressWeek3
 * 
 * 	package		com.example.congressweek3
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Mar 28, 2013
 * 
 */
package com.example.congressweek3;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;


//this class is not yet utilized in the application
public class CongressionalInfo extends GridLayout {

	TextView _firstName;
	TextView _lastName;
	TextView _chamber;
	TextView _party;
	TextView _stateName;
	Context _context;
	
	public CongressionalInfo(Context context){
		super(context);
		
		_context = context;
		
		this.setColumnCount(2);
		
		TextView firstNameLabel = new TextView(_context);
		firstNameLabel.setText("First Name:");
		_firstName = new TextView(_context);
		
		TextView lastNameLabel = new TextView(_context);
		lastNameLabel.setText("Last Name:");
		_lastName = new TextView(_context);
		
		TextView chamberLabel = new TextView(_context);
		chamberLabel.setText("Chamber:");
		_chamber = new TextView(_context);
		
		TextView partyLabel = new TextView(_context);
		partyLabel.setText("Party:");
		_party = new TextView(_context);
		
		TextView stateNameLabel = new TextView(_context);
		stateNameLabel.setText("State:");
		_stateName = new TextView(_context);
		
		
		this.addView(firstNameLabel);
		this.addView(_firstName);
		this.addView(lastNameLabel);
		this.addView(_lastName);
		this.addView(chamberLabel);
		this.addView(_chamber);
		this.addView(partyLabel);
		this.addView(_party);
		this.addView(stateNameLabel);
		this.addView(_stateName);

		
	}
}
