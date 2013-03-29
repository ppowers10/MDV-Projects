/*
 * 	project		CongressWeek3
 * 
 * 	package		com.example.congressweek4
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Mar 28, 2013
 * 
 */
package com.example.congressweek3;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Query extends LinearLayout {

	EditText _queryField;
	Button _queryButton;
	
	//creating the search edit text and button for the main view
	public Query (Context context, String hint, String buttonText){
		super(context);
		
		
		LayoutParams lp;
		
		_queryField = new EditText(context);
		_queryField.setHint(hint);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_queryField.setLayoutParams(lp);
		
		_queryButton = new Button(context);
		_queryButton.setText(buttonText);
		
		this.addView(_queryField);
		this.addView(_queryButton);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
	}
	
	public EditText getQueryText(){
		return _queryField;
	}
	
	public Button getQuery(){
		return _queryButton;
	}
	
}
