/*
 * 	project		CongressInfo
 * 
 * 	package		com.ppdesdev.congress
 * 
 * 	@author		Patrick Powers
 * 
 * 	date		May 2, 2013
 * 
 */
package com.ppdesdev.congress;

import java.util.ArrayList;
import java.util.HashMap;

import com.ppdesdev.lib.Internet;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	//setting global variables
	
		Context _context;
		Boolean connected = false;
		EditText editURI;
		Button query;
		ListView listview;
		
		private ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//set Context to this
		_context = this;
		

		//set up button for starting the content provider 
		query = (Button) this.findViewById(R.id.button1);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ProgressDialog dialog = ProgressDialog.show(_context, "", "Please Wait...");
				dialog.show();

					
				// Queries the user dictionary and returns results
				Cursor cursor = getContentResolver().query(
					NameProvider.LeaderData.CONTENT_UIR,// The content URI of the words table
				    null,                        		// The columns to return for each row
				    null,                    			// Selection criteria
				    null,                    		 	// Selection criteria
				    null);                        		// The sort order for the returned rows
				
				Log.e("CursorCournt", String.valueOf(cursor.getCount()));
				
				cursor.moveToNext();
				
				for (int i = 0; i < cursor.getCount(); i++) {
					//creating hashmap to store first and last name
					HashMap<String, String> displayMap = new HashMap<String, String>();
					Log.i("1", cursor.getString(1));
					displayMap.put("first", cursor.getString(1));
					displayMap.put("last", cursor.getString(2));
					
					cursor.moveToNext();
					
					//adding first and last name to the hashmap to mylist
					mylist.add(displayMap);
				}
				
				//loading the listview with the information.  
				listview.setVisibility(View.VISIBLE);
				SimpleAdapter adapter = new SimpleAdapter(_context, mylist, R.layout.list_row, new String[] {"first", "last"}, new int[] {R.id.first_name, R.id.last_name});
		        listview.setAdapter(adapter);
				
		        dialog.dismiss();
			}
		});
		
		
		
		//List View setup
		listview = (ListView) findViewById(R.id.listView1);
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
		    	// Prepare intent
		    	  Intent detailAct = new Intent(_context, DetailView.class);
	                String firstName = ((TextView) view.findViewById(R.id.first_name)).getText().toString();
	                String lastName = ((TextView) view.findViewById(R.id.last_name)).getText().toString();
	                Log.i("test", firstName);
	                detailAct.putExtra("firstName", firstName);
	                detailAct.putExtra("lastName", lastName);
	                // start activity
	                startActivity(detailAct);
		      }

		    });
		
		//network connection
		connected = Internet.getConnectionStatus(getApplicationContext());
			if (connected) {
				Log.i("Network:", Internet.getConnectionType(getApplicationContext()));
				Toast toast = Toast.makeText(getApplicationContext(), "WIFI Connection", Toast.LENGTH_SHORT);
				toast.show();
			}else {
				Toast toast = Toast.makeText(getApplicationContext(), "Check Internet Connection", Toast.LENGTH_SHORT);
				toast.show();
					}
		
		//set up messenger and intent that is passed to the service to start the URL and JSON saving
		Messenger messenger = new Messenger(messageHandler);
		Intent myIntent = new Intent(_context, ServiceUpdate.class);
		myIntent.putExtra("messenger", messenger);
		startService(myIntent);

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	//handle messages from the service
	private Handler messageHandler = new Handler(){
		  public void handleMessage(Message message){
	      if (message.arg1 == RESULT_OK) {
	        Toast toast = Toast.makeText(MainActivity.this,"Downloaded Complete", Toast.LENGTH_SHORT);
	        toast.show();
	      } else {
	        Toast.makeText(MainActivity.this, "Download failed.",
	            Toast.LENGTH_LONG).show();
	      }

	    };
	  };

}
