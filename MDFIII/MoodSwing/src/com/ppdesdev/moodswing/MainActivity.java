package com.ppdesdev.moodswing;

import java.io.ByteArrayOutputStream;
import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
	
	Button email;
	Button phone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		//Bitmap bitmap = BitmapFactory.decodeResource(getResources(), v.getId());     
		//ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos); 
		//byte[] b = baos.toByteArray();

		Intent intent = new Intent(this, DetailViewActivity.class);
		//intent.putExtra("picture", b);
		startActivity(intent);
	}
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.mail:
	    	Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/html");
			intent.putExtra(Intent.EXTRA_SUBJECT, "Mood Swing");
			intent.putExtra(Intent.EXTRA_TEXT, "Email someone to let them know your mood.");
			startActivity(Intent.createChooser(intent, "Send Email"));
	      
	      break;
	    case R.id.call_psycyatrist:
	    	Intent callIntent = new Intent(Intent.ACTION_DIAL);
			startActivity(callIntent);
	      break;

	    default:
	      break;
	    }

	    return true;
	  } 

}
