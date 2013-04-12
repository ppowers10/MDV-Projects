package com.ppdesdev.foodtruckorlando;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SingleFoodTruck extends Activity{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        this.setContentView(R.layout.single_truck);
	 
	        TextView truckInfo = (TextView) findViewById(R.id.truck_name);
	 
	        Intent i = getIntent();
	        // intent data
	        String truck = i.getStringExtra("truck");
	        // displaying truck name
	        truckInfo.setText(truck);
	        
	        Button webButton = (Button) findViewById(R.id.button1);
	        
	        webButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {

	            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
	            startActivity(webIntent);

	            }

	            });
	        
	        
	 
	    }
	}




