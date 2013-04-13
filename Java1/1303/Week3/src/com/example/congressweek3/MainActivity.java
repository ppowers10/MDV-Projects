/*
 * 	project		CongressWeek4
 * 
 * 	package		com.example.congressweek4
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Mar 28, 2013
 * 
 */
package com.example.congressweek3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ppdesdev.lib.Files;
import com.ppdesdev.lib.Internet;

import android.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	//setting global variables
	Context _context;
	Query _queryForm;
	Boolean connected = false;
	HashMap<String, String> _history;
	static final int REQIEST_CODE = 0;
	
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
		
		setContentView(R.layout.layout);

		_context = this;
		_history = getHistory();
		Log.i("History Read",_history.toString());
		
		//add image
		ImageView iv= (ImageView) findViewById(R.id.imageView1);
		
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
		
		Button favButton = (Button) findViewById(R.id.button2);
		favButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//	Intent i = new Intent(_context, Favorites.class);
			//	startActivityForResult(i, REQUEST_CODE);
				
			}
		});
		
		//Add Fav Button
		Button addFav = (Button) findViewById(R.id.addFavsButton);
		addFav.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	/*	
		//network connection
		connected = Internet.getConnectionStatus(_context);
		if (connected) {
			Log.i("Network:", Internet.getConnectionType(_context));
		}else {
			Toast toast = Toast.makeText(_context, "Check Internet Connection", Toast.LENGTH_SHORT);
			toast.show();
		}
		
		*/
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
	private HashMap<String, String> getHistory(){
		Object stored = Files.readObjectFile(_context, "history", false);
		
		HashMap<String, String> history;
		if (stored == null) {
			Log.i("History", "No History File Found");
			history = new HashMap<String, String>(); 
		}else{
			history = (HashMap<String, String>) stored;
		}
		return history;
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
				JSONObject jObject2 = jArray.getJSONObject(0);	
				Log.i("JSONObject", jObject2.toString());
				
				//user feedback if they type in a valid leader's name
				Toast toast = Toast.makeText(_context, "Leader found", Toast.LENGTH_SHORT);
				toast.show();
				updatedData(jObject2);
				_history.put(jObject2.getString("last_name"), jObject2.toString());
				Files.storeObjectFile(_context, "history", _history, false);
				Files.storeStringFile(_context, "temp", jObject2.toString(), true);
				
			//throws a toast when the query does not find any leaders by the searched name
			} catch (JSONException e) {
				Toast toast = Toast.makeText(_context, "No Known Leader", Toast.LENGTH_SHORT);
				toast.show();
			}
		}
		
	}
	
	

}
