package com.ppdesdev.moodswing;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
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
		
		//Bundle extras = getIntent().getExtras();
		//byte[] b = extras.getByteArray("picture");

		//Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
		ImageView image = (ImageView) findViewById(R.id.imageView1);

		//image.setImageBitmap(bmp);
		
		
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
	
}
