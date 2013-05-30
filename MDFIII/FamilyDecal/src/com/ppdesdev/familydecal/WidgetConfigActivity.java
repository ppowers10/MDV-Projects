package com.ppdesdev.familydecal;
import com.google.ads.*;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest;
import com.google.ads.InterstitialAd;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class WidgetConfigActivity extends Activity implements View.OnClickListener, AdListener {

	private Integer[] mThumbIds = {
            R.drawable.man_tie,
            R.drawable.man_tie2,
            R.drawable.man_tie3,
            R.drawable.man_tie4,
            R.drawable.pregnant,
            R.drawable.dog,
			R.drawable.man,
            R.drawable.manblack,
            R.drawable.women,
            R.drawable.womenblack,
            R.drawable.boy,
            R.drawable.boyblack,
            R.drawable.girl,
            R.drawable.girlblack,
            R.drawable.youngboy,
            R.drawable.youngboyblack,
            R.drawable.younggirl,
            R.drawable.younggirlblack,
            R.drawable.baby,
            R.drawable.babyblack,
            R.drawable.dog,
            R.drawable.dogblack,
            R.drawable.cat,
            R.drawable.catblack,
            };
	
	public static String PACKAGE_NAME;
	private InterstitialAd interstitial;
	AdRequest adRequest;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_config);
		
		// Create the interstitial
	    interstitial = new InterstitialAd(this, "e1c2d0f8ce9d40da");

	    // Create ad request
	    adRequest = new AdRequest();

	    // Begin loading your interstitial
	    interstitial.loadAd(adRequest);

	    // Begin loading your interstitial
    	interstitial.loadAd(adRequest);
    	
	    // Set Ad Listener to use the callbacks below
	    interstitial.setAdListener(this);

	
		GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));
	    gridview.setOnItemClickListener(itemClickListener);

	    PACKAGE_NAME = getApplicationContext().getPackageName();
	}
	
	@Override
	  public void onReceiveAd(Ad ad) {
	    Log.d("OK", "Received ad");
	    if (ad == interstitial) {
	      //interstitial.show();
	    }
	  }
	
	private OnItemClickListener itemClickListener = new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	    	
	    	Bundle extras = getIntent().getExtras();
			
			if(extras != null){
				int widgetID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
				
				if(widgetID != AppWidgetManager.INVALID_APPWIDGET_ID);
				{
					RemoteViews rv = new RemoteViews(PACKAGE_NAME, R.layout.widget_layout);
					
						//interstitial.show();
						
				        //handle the click here
						String name = ((EditText)findViewById(R.id.widgetname)).getText().toString();
						String phone = ((EditText)findViewById(R.id.phonenumber)).getText().toString();
						rv.setImageViewResource(R.id.button, mThumbIds[position]);
						rv.setTextViewText(R.id.nametext, name);

						if(!phone.matches("")){
						String uri = "tel:" + phone.trim() ;
						Intent butonIntent = new Intent(Intent.ACTION_DIAL);
						butonIntent.setData(Uri.parse(uri));
						PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, butonIntent, 0);
						rv.setOnClickPendingIntent(R.id.button, pi);
						}
						
						AppWidgetManager.getInstance(getApplicationContext()).updateAppWidget(widgetID, rv);
						Intent resultValue = new Intent();
						resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
						setResult(RESULT_OK, resultValue);
						finish();
				}
			}
	    }
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public class ImageAdapter extends BaseAdapter {
		 
	       private Context mContext;
	 
	       public ImageAdapter(Context c) {
	           mContext = c;
	       }
	 
	       @Override
	       public int getCount() {
	           return mThumbIds.length;
	       }
	 
	       @Override
	       public Object getItem(int arg0) {
	           return null;
	       }
	       
	       @Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
	 
	       @Override
	       public View getView(int position, View convertView, ViewGroup parent) {
	 
	    	   ImageView imageView;
	           if (convertView == null) {  // if it's not recycled, initialize some attributes
	               imageView = new ImageView(mContext);
	               imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
	               imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	               imageView.setPadding(8, 8, 8, 8);
	           } else {
	               imageView = (ImageView) convertView;
	           }

	           imageView.setImageResource(mThumbIds[position]);
	           return imageView;
	       }
	   }


	@Override
	public void onClick(View v) {
		
	}

	@Override
	public void onDismissScreen(Ad arg0) {
		
	}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
		
	}

	@Override
	public void onLeaveApplication(Ad arg0) {
		
	}

	@Override
	public void onPresentScreen(Ad arg0) {
		
	}
}
