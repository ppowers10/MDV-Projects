/*
 * 	project		CongressLeaders
 * 
 * 	package		com.example.congressLeaders
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Apr 14, 2013
 * 
 */
package com.example.congressLeaders;

import java.net.MalformedURLException;
import java.net.URL;
//import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ppdesdev.lib.Files;
import com.ppdesdev.lib.Internet;

import com.example.congressLeaders.MainFragment.MainListeners;
import com.example.congressLeaders.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
//import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements MainFragment.MainListeners {

	//setting global variables
	Context _context;
	Boolean connected = false;
	JSONObject _history;
	JSONObject jObject2;
	//HashMap<String, String> _history;
	
	//after the query, set the textViews to the correct information
	public void updatedData(JSONObject data){
		try{
			((TextView) findViewById(R.id.data_firstName)).setText(data.getString("first_name"));
			((TextView) findViewById(R.id.data_LastName)).setText(data.getString("last_name"));
			((TextView) findViewById(R.id.data_chamber)).setText(data.getString("chamber"));
			((TextView) findViewById(R.id.data_party)).setText(data.getString("party"));
			((TextView) findViewById(R.id.data_stateName)).setText(data.getString("state_name"));
		}catch(JSONException e){
			Log.e("JSON Error", e.toString());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		//Remove title bar and set content
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);		
		setContentView(R.layout.layout_frag);

		_context = this;
	//	_history = getHistory();
	//	Log.i("History Read",_history.toString());
		
		/*
		 * Delete here
		 * 
		 * 
		//add search handler
		Button queryButton = (Button) findViewById(R.id.button1);		
		//on click for the query
		queryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText queryField = (EditText) findViewById(R.id.editText1);
				Log.i("Click Handler", queryField.getText().toString());
				getName(queryField.getText().toString());
			}
		});
		
		*
		*Delete here
		*/
		
		/*
		 * Delete here
		 * 
		//More Info Button
		Button singleLeader = (Button) findViewById(R.id.moreInfoButton);
		singleLeader.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				try{
					String firstName = jObject2.getString("first_name");
					String lastName = jObject2.getString("last_name");
					String fullName = firstName + " " + lastName;
					String chamber = jObject2.getString("chamber");
					String party = jObject2.getString("party");
					String stateName = jObject2.getString("state_name");
					String birthday = jObject2.getString("birthday");
					String phone = jObject2.getString("phone");
					String contactForm = jObject2.getString("contact_form");
					String gender = jObject2.getString("gender");
					String officeAddress = jObject2.getString("office");
					String fax = jObject2.getString("fax");
					String website = jObject2.getString("website");
					
					Intent i = new Intent(getApplicationContext(), SingleLeaderInfo.class);
		              // sending data
		              i.putExtra("name", fullName);
		              i.putExtra("chamber", chamber);
		              i.putExtra("party", party);
		              i.putExtra("state", stateName);
		              i.putExtra("birthday", birthday);
		              i.putExtra("phone", phone);
		              i.putExtra("contact Form", contactForm);
		              i.putExtra("gender", gender);
		              i.putExtra("office", officeAddress);
		              i.putExtra("fax", fax);
		              i.putExtra("website", website);
		              startActivityForResult(i, 0);
					
				}catch(JSONException e){
					Log.e("JSON Error", e.toString());
				}
	              
			}
		});
		
		*
		*Delete here
		*
		*/
		
		//network connection
		connected = Internet.getConnectionStatus(_context);
		if (connected) {
			Log.i("Network:", Internet.getConnectionType(_context));
		}else {
			Toast toast = Toast.makeText(_context, "Check Internet Connection", Toast.LENGTH_SHORT);
			toast.show();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	//creating the URL for the API
	private void getName(String leaderName){
		Log.i("Click", leaderName);
		String queryURL = "http://congress.api.sunlightfoundation.com/legislators?apikey=aa5cc069fd444cb5925da14a2a8a123b&query=" + leaderName;
		URL finalURL;
		try {
			finalURL = new URL(queryURL);
			LeaderRequest lr = new LeaderRequest();
			lr.execute(finalURL);
		} catch (MalformedURLException e) {
			Log.e("Bad URL", "Malformed URL");
			finalURL = null;
		}
	}
	
	//retrieving information from the stored history
	private JSONObject getHistory(){
		//private HashMap<String, String> getHistory(){
			
			String JSONString = Files.readStringFile(_context, "history", false);
	        JSONObject job = null;
	        try {
	            job = new JSONObject(JSONString);
	        } catch (JSONException e) {
	            // TODO Auto-generated catch block
	           e.printStackTrace();
	        }

			/*changed to a jsonObject
			Object stored = Files.readObjectFile(_context, "history", false);
			
			HashMap<String, String> history;
			if (stored == null) {
				Log.i("History", "No History File Found");
				history = new HashMap<String, String>(); 
			}else{
				history = (HashMap<String, String>) stored;
			}
			*/
			return job;
	}
	
	//fetching JSON data from the url API
	private class LeaderRequest extends AsyncTask<URL, Void, String>{
		
		@Override
		protected String doInBackground(URL... urls){
			String response = "";
			for(URL url: urls){
				response = Internet.getURL(url);
			}
			return response;
		}
		@Override
		protected void onPostExecute(String result){
			Log.i("URL Response", result);
			try{
				JSONObject jObject = new JSONObject(result);
				JSONArray jArray = jObject.getJSONArray("results");
				Log.i("jArray", jArray.toString());
				jObject2 = jArray.getJSONObject(0);	
				Log.i("JSONObject", jObject2.toString());
				
				//user feedback if they type in a valid leader's name
				Toast toast = Toast.makeText(_context, "Leader found", Toast.LENGTH_SHORT);
				toast.show();
				updatedData(jObject2);
			//	_history.put(jObject2.getString("last_name"), jObject2);
			//	_history.put(jObject2.getString("last_name"), jObject2.toString());
			//	Files.storeObjectFile(_context, "history", _history, false);
			//	Files.storeStringFile(_context, "temp", jObject2.toString(), true);
				
			//throws a toast when the query does not find any leaders by the searched name
			} catch (JSONException e) {
				Toast toast = Toast.makeText(_context, "No Known Leader", Toast.LENGTH_SHORT);
				toast.show();
			}
		}
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (resultCode == RESULT_OK){
			String passedString = data.getStringExtra("response");
			Toast toast = Toast.makeText(_context, passedString, Toast.LENGTH_SHORT);
			toast.show();
		}
	}

	@Override
	public void onLeaderSearch(String name) {

		getName(name);
		
	}

	@Override
	public void onDetailView() {
		
		try{
			String firstName = jObject2.getString("first_name");
			String lastName = jObject2.getString("last_name");
			String fullName = firstName + " " + lastName;
			String chamber = jObject2.getString("chamber");
			String party = jObject2.getString("party");
			String stateName = jObject2.getString("state_name");
			String birthday = jObject2.getString("birthday");
			String phone = jObject2.getString("phone");
			String contactForm = jObject2.getString("contact_form");
			String gender = jObject2.getString("gender");
			String officeAddress = jObject2.getString("office");
			String fax = jObject2.getString("fax");
			String website = jObject2.getString("website");
			
			Intent i = new Intent(getApplicationContext(), SingleLeaderInfo.class);
              // sending data
              i.putExtra("name", fullName);
              i.putExtra("chamber", chamber);
              i.putExtra("party", party);
              i.putExtra("state", stateName);
              i.putExtra("birthday", birthday);
              i.putExtra("phone", phone);
              i.putExtra("contact Form", contactForm);
              i.putExtra("gender", gender);
              i.putExtra("office", officeAddress);
              i.putExtra("fax", fax);
              i.putExtra("website", website);
              startActivityForResult(i, 0);
			
		}catch(JSONException e){
			Log.e("JSON Error", e.toString());
		}
		
	}
	

}
