package com.ppdesdev.foodtruckorlando;


import com.ppdesdev.lib.WebStuff;

import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	Boolean connected = false;
	Context _context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		// storing string resources into Array
        String[] foodTruckNames = getResources().getStringArray(R.array.food_truck_names);
 
        // Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, foodTruckNames));
 
        ListView lv = getListView();
        
        // truck clicked within list
        lv.setOnItemClickListener(new OnItemClickListener() {
          @Override
		public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
 
              // selected truck
              String truck = ((TextView) view).getText().toString();
 
              // Explicit intent to launch singleFoodTruck class
              Intent i = new Intent(getApplicationContext(), SingleFoodTruck.class);
              // sending data
              i.putExtra("truck", truck);
              startActivity(i);
          }
        });
        
       /* 
        //detect network connection
       connected = WebStuff.getConnectionStatus(_context);
       	if(connected){
     	Log.i("Network:", WebStuff.getConnectionType(_context));
		}
       	else {
			Toast toast = Toast.makeText(_context, "Check Internet Connection", Toast.LENGTH_SHORT);
			toast.show();
		}
        */
		
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
