/*
 * 	project		MoodSwing
 * 
 * 	package		com.ppdesdev.moodswing
 * 
 * 	@author		patrickpowers
 * 
 * 	date		May 23, 2013
 * 
 */
package com.ppdesdev.moodswing;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DetailViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_view);
		
		//**attempting to turn drawable resource to byte to transfer to detail activity
		//Bundle extras = getIntent().getExtras();
		//byte[] b = extras.getByteArray("picture");
		//Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		//image.setImageBitmap(bmp);
		
		//button on click handler to post the mood information
		Button postButton = (Button) findViewById(R.id.button1);
		postButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String subject = ((EditText)findViewById(R.id.editText1)).getText().toString();
				String body = ((EditText)findViewById(R.id.editText2)).getText().toString();
				Intent shareIntent=new Intent(Intent.ACTION_SEND);
		        shareIntent.setType("text/plain");
		        shareIntent.putExtra(Intent.EXTRA_TEXT, body);
		        shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		        startActivity(Intent.createChooser(shareIntent, "Share..."));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    //determining which action button was clicked and forming proper intents
	    case R.id.mail:
	    	Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/html");
			intent.putExtra(Intent.EXTRA_SUBJECT, "Mood Swing");
			intent.putExtra(Intent.EXTRA_TEXT, "Email someone to let them know your mood.");
			startActivity(Intent.createChooser(intent, "Send Email"));
	      
	      break;
	      //call intent
	    case R.id.call_psycyatrist:
	    	Intent callIntent = new Intent(Intent.ACTION_DIAL);
			startActivity(callIntent);
	      break;
	      //navigation
	    case android.R.id.home:
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
          break;

	    default:
	      break;
	    }

	    return true;
	  } 
	
}
