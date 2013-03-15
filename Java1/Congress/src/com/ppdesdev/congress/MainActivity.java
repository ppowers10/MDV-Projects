/*
 * 	project		Congress
 * 
 * 	package		com.ppdesdev.congress
 * 
 * 	@author		Patrick Powers
 * 
 * 	date		March 14, 2013
 * 
 */
package com.ppdesdev.congress;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONException;
import org.json.JSONObject;

import com.ppdesdev.congress.R;
import com.ppdesdev.lib.CreateForms;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	//define global variables
	LinearLayout layout;
	LinearLayout group;
	LinearLayout.LayoutParams layoutP;
    JSONObject congressMember;
    TextView tSpace;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//create basic layout for the app
		layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layoutP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		
		//set initial header text 
		TextView tv = new TextView(this);
		tv.setText("Who is your local Congressional leader?");
		//add the text to the layout
		layout.addView(tv);
				
		//call to CreateForms to set up search box and button
		LinearLayout queryBox = CreateForms.queryWithButon(this, "Type Congressional Name", "Search");

		//connect the search button to the tag in CreateForms
		Button searchButton = (Button) queryBox.findViewById(2);
		
	    //Create JSON object by calling to resource files for static data
	    congressMember = new JSONObject();	

				try {
					congressMember.put("firstName", getResources().getString(R.string.firstName));
					congressMember.put("lastName", getResources().getString(R.string.lastName));
					congressMember.put("party", getResources().getString(R.string.party));
					congressMember.put("office", getResources().getString(R.string.office));
					congressMember.put("stateName", getResources().getString(R.string.stateName));
					congressMember.put("runForPresident", getResources().getString(R.string.runForPresident));
					congressMember.put("president", getResources().getInteger(R.integer.president));
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		//create the on click event to use the name typed in the edit text field to output the senators info
		searchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText name = (EditText) v.getTag();
				
				try {
					//check if the person ran for president and if print info based on if they did or did not
					String didRun = congressMember.get("runForPresident").toString();
					Log.i("Run for Present" , didRun);
					
					if (didRun.equals("Yes")) {
						tSpace.setText(
								congressMember.get("office") + "\r\n" +
								congressMember.get("firstName") + "\r\n" +
								congressMember.get("lastName") + "\r\n" +
								congressMember.get("party") + "\r\n" +
								congressMember.get("stateName") + "\r\n" +
								"Ran for Presedent " + congressMember.get("president") + " time(s).\r\n");
					}else {
						tSpace.setText(
								congressMember.get("office") + "\r\n" +
								congressMember.get("firstName") + "\r\n" +
								congressMember.get("lastName") + "\r\n" +
								congressMember.get("party") + "\r\n" +
								congressMember.get("stateName") + "\r\n");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		//adding the additional layouts to the main layout
		group = new LinearLayout(this);
		group.setOrientation(LinearLayout.HORIZONTAL);
		layoutP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		group.addView(queryBox);
		layout.addView(group);
		
		tSpace = new TextView(this);
		layout.addView(tSpace);
		
		setContentView(layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
