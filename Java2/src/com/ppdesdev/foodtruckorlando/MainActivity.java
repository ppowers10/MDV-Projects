package com.ppdesdev.foodtruckorlando;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	
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
        

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
