package com.ppdesdev.pictureshare;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	LinearLayout ll;
	ImageView img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		ll = (LinearLayout) findViewById(R.id.RelativeLayout1);
		img = (ImageView) findViewById(R.id.ImageView1);
		Button bt = (Button) findViewById(R.id.Button1);
		
		//take a screenshot
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				View view = ll.getRootView();
                view.setDrawingCacheEnabled(true);
                Bitmap bm = view.getDrawingCache();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bm);
                Bitmap b = bitmapDrawable.getBitmap();
                Images.Media.insertImage(getContentResolver(), b, null, null);
                img = (ImageView) findViewById(R.id.ImageView1);
                img.setBackgroundDrawable(bitmapDrawable);

			}
		});
		
		// Get intent, action and MIME type
	    Intent intent = getIntent();
	    String action = intent.getAction();
	    String type = intent.getType();


	    if (Intent.ACTION_SEND.equals(action) && type != null) {
	        if (type.startsWith("image/")) {
	            handleSendImage(intent); // Handle single image being sent
	        	}
	        
	        }
	        else {
	        // Handle other intents, such as being started from the home screen
	        }
	    }

	
	void handleSendImage(Intent intent) {
	    Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
	    if (imageUri != null) {
	    	img.setImageURI(imageUri);
	    	
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		

		
		return true;
	}
}
