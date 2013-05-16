package com.ppdesdev.photostamp;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("SimpleDateFormat")
public class MainActivity extends Activity {

	Context _context;
	private Uri imageUri;
	ImageView img;
	static final int INTENT_REQUEST_CODE = 0;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDateandTime = sdf.format(new Date());
		TextView dateTime = (TextView) findViewById(R.id.date);
		dateTime.setText(currentDateandTime);
		
		img = (ImageView) findViewById(R.id.imageView1);
		ImageButton cameraButton = (ImageButton) findViewById(R.id.imageButton1);
		cameraButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
			    File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
			    intent.putExtra(MediaStore.EXTRA_OUTPUT,
			            Uri.fromFile(photo));
			    imageUri = Uri.fromFile(photo);
			    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
			}
		});
		
		ImageButton infoButton = (ImageButton) findViewById(R.id.info);
		infoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(getApplicationContext(), InfoActivity.class);
				startActivityForResult(i, INTENT_REQUEST_CODE);
				
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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
		            Uri selectedImage = imageUri;
		            getContentResolver().notifyChange(selectedImage, null);
		            ContentResolver cr = getContentResolver();
		            Bitmap bitmap;
		            try {
		                 bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, selectedImage);
	
		                img.setImageBitmap(bitmap);
		            } catch (Exception e) {
		                Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT)
		                        .show();
		                Log.e("Camera", e.toString());
		            }
		        }
		    }
	
		if (requestCode == INTENT_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
			TextView address = (TextView) findViewById(R.id.address);
			TextView longitude = (TextView) findViewById(R.id.textView4);
			TextView latitude = (TextView) findViewById(R.id.textView3);
			
			address.setText(data.getExtras().getString("address"));
			longitude.setText(data.getExtras().getString("long"));
			latitude.setText(data.getExtras().getString("lat"));
			}
		}
	}
		
}
