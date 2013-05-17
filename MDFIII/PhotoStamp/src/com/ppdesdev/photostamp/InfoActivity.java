package com.ppdesdev.photostamp;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

public class InfoActivity extends Activity implements LocationListener{
	
	EditText et;
	TextView latitude;
	TextView longitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.info_layout);
		
		et = (EditText) findViewById(R.id.editText1);
		latitude = (TextView) findViewById(R.id.TextView02);
		longitude = (TextView) findViewById(R.id.textView3);
	    
	    LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 50L, 1.0f, this);
	    
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
			if(ni == null){
				latitude.setText("N/A");
				longitude.setText("N/A");
				new AlertDialog.Builder(this)
				.setTitle("GPS")
				.setMessage("Check your internt connection. GPS coordinates cannot be determined without internet connection.")
				.setNeutralButton("Close", null)
				.show();
	
			}

		
		Button returnInfo = (Button) findViewById(R.id.button1);
		returnInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String address = (String) et.getText().toString();
				String lng = (String) longitude.getText().toString();
				String lat = (String) latitude.getText().toString();
				
				Intent returnIntent = new Intent();
				returnIntent.putExtra("address", address);
				returnIntent.putExtra("long", lng);
				returnIntent.putExtra("lat", lat);
				setResult(RESULT_OK, returnIntent);
				finish();
				
			}
		});
	}

	@Override
	public void onLocationChanged(Location l) {
		// TODO Auto-generated method stub
		this.longitude.setText(String.valueOf(l.getLongitude()));
		this.latitude.setText(String.valueOf(l.getLatitude()));
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
