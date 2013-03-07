/*
 * 	project		Week11303
 * 
 * 	package		com.ppdesdev.week11303
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Mar 4, 2013
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

	LinearLayout lv;
	LinearLayout.LayoutParams la;
	EditText eSpace;
	EditText eSpace2;
	TextView tSpace3;
	TextView tSpace4;
	TextView tSpace5;
	static TextView tSpace6;
	static private String[] pets = {"Lion", "Tiger","Bear", "Shark"};
	
	private static void myPet(){
		tSpace6.setText("I have 2 dogs.");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		lv = new LinearLayout(this);
		lv.setOrientation(LinearLayout.VERTICAL);
		la = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		lv.setLayoutParams(la);
		
		TextView tSpace = new TextView(this);
		tSpace.setText("What type of pet do you own?");
		
		lv.addView(tSpace);
		
		eSpace = new EditText(this);
		eSpace.setHint("Type name of pet type here.");
		
		lv.addView(eSpace);
		
		eSpace2 = new EditText(this);
		eSpace2.setHint("Type how many you own here.");
		
		
		Button bSpace = new Button(this);
		bSpace.setText("Button");
		//lv.addView(bSpace);
		
		bSpace.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int zero = getResources().getInteger(R.integer.zero);
				int one = getResources().getInteger(R.integer.one);
				int two = getResources().getInteger(R.integer.two);
				int three = getResources().getInteger(R.integer.three);
				int four = getResources().getInteger(R.integer.four);
				boolean x = (zero == 0);
				
				int num = Integer.parseInt(eSpace2.getText().toString());
				String pet = (String) eSpace.getText().toString();
				
				if (x == true) {
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
				
				tSpace4.setText("\nDid you ever want to own a:");
				
				for (int i = 0; i < pets.length; i++) {
					tSpace5.setText(pets[i]);
				}
				
				myPet();
			}
		});
		
		LinearLayout lv2 = new LinearLayout(this);
		lv2.setOrientation(LinearLayout.HORIZONTAL);
		la = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lv2.setLayoutParams(la);
		
		lv2.addView(eSpace2);
		lv2.addView(bSpace);
		
		lv.addView(lv2);
		
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
