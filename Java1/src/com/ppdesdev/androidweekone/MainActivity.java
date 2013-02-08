package com.ppdesdev.androidweekone;

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

	//variables
	LinearLayout layout;
	LinearLayout.LayoutParams layoutP;
	String titleText;
	EditText editText;
	TextView input;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//creating initial linear layout
		layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		layoutP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		
		layout.setLayoutParams(layoutP);
		//text view
		TextView textView = new TextView(this);
		//pulling from resource
		textView.setText(getString(R.string.title));
		
		layout.addView(textView);
		
		//edit text
		editText = new EditText(this);
		editText.setHint("Type a # 1-5");
		
		Button button1 = new Button(this);
		button1.setText("Is Even?");
		
		//click event handler
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//ints
				int one = 1;
				int two = 2;
				int three = 3;
				int four = 4;
				int five = 5;
				
				int num = Integer.parseInt(editText.getText().toString());
				//condition
				if (num == one) {
					input.setText(num + " is not even.");
				}else if (num == two) {
					input.setText(num + " is even.");
				}else if (num == three) {
					input.setText(num + " is not even.");
				}else if (num == four) {
					input.setText(num + " is even.");
				}else if (num == five) {
					input.setText(num + " is not even, but 5\'s are cool.");
				}else {
					//loop...just because
					for (int i=num; i<5; i++)
					{
						if(i == 5)
						{
							input.setText("I don\'t thing you typed a number from 1-5");
						}
					}
				}
				
				
				
			}
		});
		
		//boolean
		boolean isEven = true;
		
		//comparision
		if (isEven = true)
		{
			//add the new text view 
			TextView textView2 = new TextView(this);
			textView2.setText("Did I tell you I like EVEN numbers!");
			
			layout.addView(textView2);
		}
		
		//nested linear layout
		LinearLayout group = new LinearLayout(this);
		group.setOrientation(LinearLayout.HORIZONTAL);
		layoutP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		//
		group.addView(editText);
		group.addView(button1);
		
		layout.addView(group);
		
		input = new TextView(this);
		layout.addView(input);
		
		
		setContentView(layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
