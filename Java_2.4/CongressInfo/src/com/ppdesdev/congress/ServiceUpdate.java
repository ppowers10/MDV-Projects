/*
 * 	project		CongressInfo
 * 
 * 	package		com.ppdesdev.congress
 * 
 * 	@author		patrickpowers
 * 
 * 	date		May 2, 2013
 * 
 */
package com.ppdesdev.congress;

import java.net.MalformedURLException;
import java.net.URL;


import org.json.JSONObject;

import com.ppdesdev.lib.Files;
import com.ppdesdev.lib.Internet;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class ServiceUpdate extends IntentService {

	//setting global variables
	Boolean connected = false;
	JSONObject jObject;
	private int result = Activity.RESULT_CANCELED;
	public static String JSON_RESULTS = "results";
	public static String JSON_FIRST = "first_name";
	public static String JSON_LAST = "last_name";
	
	public ServiceUpdate() {
		super("ServiceUpdate");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d("TAG", "Service started");
			
		String queryURL = "http://congress.api.sunlightfoundation.com/legislators?apikey=aa5cc069fd444cb5925da14a2a8a123b&per_page=all";
		URL finalURL;
		try {
			//turn string into URL
			finalURL = new URL(queryURL);
			//pass URL to Interent.getURL to turn into a JSON string
			String response = Internet.getURL(finalURL);
			Log.i("URL Response", response);
			//store the JSON string to storage
			Files.storeStringFile(getApplicationContext(), "congressNames", response, true);
			//turn JSON string into an object to pass back to Activity
			
			//set result to OK to pass back to handler in mainActivity
			result = Activity.RESULT_OK;
		
		} catch (MalformedURLException e) {
			Log.e("Bad URL", "Malformed URL");
			finalURL = null;
		}
		
		//getting the OK message to send back to the main activity
		Bundle extras = intent.getExtras();
	    if (extras != null) {
	      Messenger messenger = (Messenger) extras.get("messenger");
	      Message msg = Message.obtain();
	      msg.arg1 = result;
	      try {
	        messenger.send(msg);
	      } catch (android.os.RemoteException e1) {
	        Log.w(getClass().getName(), "Exception sending message", e1);
	      }
	    }
	}

}
