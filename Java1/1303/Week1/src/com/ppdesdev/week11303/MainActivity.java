/*
 * 	project		Week11303
 * 
 * 	package		com.ppdesdev.week11303
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Mar 7, 2013
 * 
 */
package com.ppdesdev.week11303;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	//define variables
	LinearLayout lv;
	LinearLayout.LayoutParams la;
	EditText eSpace;
	EditText eSpace2;
	TextView tSpace3;
	TextView tSpace4;
	TextView tSpace5;
	static TextView tSpace6;
	static private String[] pets = {"Lion", "Tiger","Bear", "Shark"};
	
	//function
	private static void myPet(){
		tSpace6.setText("I have 2 dogs.");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		//set up linear layout for app
		lv = new LinearLayout(this);
		lv.setOrientation(LinearLayout.VERTICAL);
		la = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		lv.setLayoutParams(la);
		
		//text view with initial text
		TextView tSpace = new TextView(this);
		tSpace.setText("What type of pet do you own?");
		
		//add text view to layout
		lv.addView(tSpace);
		
		//two edit text feilds for pet type and number
		eSpace = new EditText(this);
		eSpace.setHint("Type name of pet type here.");
		
		lv.addView(eSpace);
		
		eSpace2 = new EditText(this);
		eSpace2.setHint("Type how many you own here.");
		
		//button for submitting and receiving results
		Button bSpace = new Button(this);
		bSpace.setText("Button");
		
		//on click funtion for button
		bSpace.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//calling to resources to set int values
				int zero = getResources().getInteger(R.integer.zero);
				int one = getResources().getInteger(R.integer.one);
				int two = getResources().getInteger(R.integer.two);
				int three = getResources().getInteger(R.integer.three);
				int four = getResources().getInteger(R.integer.four);
				boolean x = (zero != 0);
				
				int num = Integer.parseInt(eSpace2.getText().toString());
				String pet = (String) eSpace.getText().toString();
				
				//conditional
				if (num == 0 && x == true) {
					tSpace3.setText("You have " + num + " " + pet +"(s). That means you don't own any " + pet + "(s).  Why did you say you owned a " + pet +".");
				}else if (num == one) {
					tSpace3.setText("You have " + num + " " + pet +"(s).");
				}else if (num == two) {
					tSpace3.setText("You have " + num + " " + pet +"(s).");
				}else if (num == three) {
					tSpace3.setText("You have " + num + " " + pet +"(s).");
				}else if (num >= four) {
					tSpace3.setText("You have " + num + " " + pet +"(s). That is a LOT!");
				}else {
				}
				
				//set 
				tSpace4.setText("\nDid you ever want to own a:");
				
				for (int i = 0; i < pets.length; i++) {
					String petArrayText = (String) tSpace5.getText().toString();
					tSpace5.setText(petArrayText + ", " + pets[i]);
				}
				
				myPet();
			}
		});
		
		//creating the layout for the second edit text and button
		LinearLayout lv2 = new LinearLayout(this);
		lv2.setOrientation(LinearLayout.HORIZONTAL);
		la = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lv2.setLayoutParams(la);
		
		lv2.addView(eSpace2);
		lv2.addView(bSpace);
		
		lv.addView(lv2);
		
		//the remaining text views that are added after the on click function is called
		
		tSpace3 = new TextView(this);
		
		lv.addView(tSpace3);
		
		tSpace4 = new TextView(this);
		
		lv.addView(tSpace4);
		
		tSpace5 = new TextView(this);
		
		lv.addView(tSpace5);
		
		tSpace6 = new TextView(this);
		
		lv.addView(tSpace6);
		
		setContentView(lv);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
