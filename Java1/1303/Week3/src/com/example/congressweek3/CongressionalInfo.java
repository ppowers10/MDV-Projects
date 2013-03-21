package com.example.congressweek3;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class CongressionalInfo extends GridLayout {

	TextView _firstName;
	TextView _lastName;
	TextView _chamber;
	TextView _birthday;
	TextView _contactForm;
	TextView _fax;
	TextView _phone;
	TextView _party;
	TextView _stateName;
	TextView _website;
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
		
		TextView birthdayLabel = new TextView(_context);
		birthdayLabel.setText("Birthday:");
		_birthday = new TextView(_context);
		
		TextView contactFormLabel = new TextView(_context);
		contactFormLabel.setText("Contact Form:");
		_contactForm = new TextView(_context);
		
		TextView faxLabel = new TextView(_context);
		faxLabel.setText("Fax Number:");
		_fax = new TextView(_context);
		
		TextView phoneLabel = new TextView(_context);
		phoneLabel.setText("Phone Number:");
		_phone = new TextView(_context);
		
		TextView partyLabel = new TextView(_context);
		partyLabel.setText("Party:");
		_party = new TextView(_context);
		
		TextView stateNameLabel = new TextView(_context);
		stateNameLabel.setText("State:");
		_stateName = new TextView(_context);
		
		TextView websiteLabel = new TextView(_context);
		websiteLabel.setText("Website:");
		_website = new TextView(_context);
		
		this.addView(firstNameLabel);
		this.addView(_firstName);
		this.addView(lastNameLabel);
		this.addView(_lastName);
		this.addView(chamberLabel);
		this.addView(_chamber);
		this.addView(birthdayLabel);
		this.addView(_birthday);
		this.addView(contactFormLabel);
		this.addView(_contactForm);
		this.addView(faxLabel);
		this.addView(_fax);
		this.addView(phoneLabel);
		this.addView(_phone);
		this.addView(partyLabel);
		this.addView(_party);
		this.addView(stateNameLabel);
		this.addView(_stateName);
		this.addView(websiteLabel);
		this.addView(_website);
		
	}
}
