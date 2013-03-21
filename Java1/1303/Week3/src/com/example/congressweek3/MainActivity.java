package com.example.congressweek3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

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
import android.widget.Toast;

public class MainActivity extends Activity {

	Context _context;
	LinearLayout _layout;
	Query _queryForm;
	CongressionalInfo _leader;
	Boolean connected = false;
	HashMap<String, String> _history;
	
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
		
		//add congressional leader info
		_leader = new CongressionalInfo(_context);
		
		//add views to main layout
		_layout.addView(_queryForm);
		_layout.addView(_leader);
		
		_layout.setOrientation(LinearLayout.VERTICAL);
		
		setContentView(_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
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
			JSONObject json = new JSONObject(result);
			JSONObject results = json.getJSONObject("results");
			JSONObject count = json.getJSONObject("count");
				if (count.get("count") == "0") {
					Toast toast = Toast.makeText(_context, "No Known Leader", Toast.LENGTH_SHORT);
					toast.show();
				}else {
					Toast toast = Toast.makeText(_context, "Leader found", Toast.LENGTH_SHORT);
					toast.show();
					_history.put(results.getString("last_name"), results.toString());
					Files.storeObjectFile(_context, "history", _history, false);
				}
			} catch (JSONException e) {
				Log.e("JSON", "JSON object exception");
			}
		}
		
	}

}
