package com.example.congressweek3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ppdesdev.lib.Files;
import com.ppdesdev.lib.Internet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	//setting global variables
	Context _context;
	LinearLayout _layout;
	Query _queryForm;
	CongressionalInfo _leader;
	Boolean connected = false;
	HashMap<String, String> _history;
	TextView tSpace;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		_context = this;
		_layout = new LinearLayout(this);
		_history = new HashMap<String, String>();
		
		
		_queryForm = new Query(_context, "Type Name Here", "Search");
		
		//add search handler
		EditText queryField = _queryForm.getQueryText();
		Button queryButton = _queryForm.getQuery();
		
		
		//on click for the query
		queryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("Click Handler", _queryForm.getQueryText().getText().toString());
				getName(_queryForm.getQueryText().getText().toString());
			}
		});
		
		//network connection
		connected = Internet.getConnectionStatus(_context);
		if (connected) {
			Log.i("Network:", Internet.getConnectionType(_context));
		}
		
		//add congressional leader info - not using yet, but might next week
		//_leader = new CongressionalInfo(_context);
		
		
		//add views to main layout
		_layout.addView(_queryForm);
		//_layout.addView(_leader);
		
		tSpace = new TextView(this);
		_layout.addView(tSpace);
		
		_layout.setOrientation(LinearLayout.VERTICAL);
		
		setContentView(_layout);
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
				_history.put(jObject2.getString("last_name"), jObject2.toString());
				Files.storeObjectFile(_context, "history", _history, false);
				Files.storeStringFile(_context, "temp", jObject2.toString(), true);
					
				//setting the data in the main view for the user
				tSpace.setText(
							"First Name: " + jObject2.get("first_name") + "\r\n" +
							"Last Name: " +jObject2.get("last_name") + "\r\n" +
							"Chamber: " +jObject2.get("chamber") + "\r\n" +
							"Party: " +jObject2.get("party") + "\r\n" +
							"State: " +jObject2.get("state_name") + "\r\n" );
					
			//throws a toast when the query does not find any leaders by the searched name
			} catch (JSONException e) {
				Toast toast = Toast.makeText(_context, "No Known Leader", Toast.LENGTH_SHORT);
				toast.show();
				
				tSpace.setText(
						"First Name: " + "\r\n" +
						"Last Name: " + "\r\n" +
						"Chamber: " + "\r\n" +
						"Party: " + "\r\n" +
						"State: " + "\r\n" );
			}
		}
		
	}
	
	

}
