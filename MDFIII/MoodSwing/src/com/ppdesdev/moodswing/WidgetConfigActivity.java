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
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

public class WidgetConfigActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//using the same layout as the home screen to pick the mood
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.widget_config, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Bundle extras = getIntent().getExtras();
		
		if(extras != null){
			int widgetID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
			
			if(widgetID != AppWidgetManager.INVALID_APPWIDGET_ID);
			{
				RemoteViews rv = new RemoteViews(this.getPackageName(), R.layout.widget_layout);
				
				//checking the button that was licked
				//creating toast to let user know the setting that was set
				//place pendingIntent on button
				//update the widget
				if(v.getId() == R.id.angry){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Angry", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.angry);
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
			    }
				if(v.getId() == R.id.bigGrin){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Happy", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.big_grin); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
			    }
				if(v.getId() == R.id.bomb){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Ready to go off", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.bomb); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.brokenHeart){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Broken Hearted", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.broken_heart); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.confused){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Confused", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.confused); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.cold){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Cold", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.cold); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.cool){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Great job", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.cool); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.crying){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Sad", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.crying); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.crying2){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Crying", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.crying2); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.dead){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Out of it", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.dead); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.devil){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Feeling Evil", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.devil); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.dizzy){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Dizzy", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.dizzy); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.dontTellAnyone){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Secret", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.donttell_anyone); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.drinks){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Ready for a Drink", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.drinks); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.drolling){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Craving", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.drooling); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.goodbye){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Tchau", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.goodbye); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.heart){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Loved", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.heart); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
				if(v.getId() == R.id.hug){
			        //handle the click here
					Toast.makeText(getApplicationContext(), "Widget set to Giving Love", Toast.LENGTH_SHORT).show();
					rv.setImageViewResource(R.id.button2, R.drawable.hug); 
					
					Intent butonIntent = new Intent(this, MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this, 0, butonIntent, 0);
					rv.setOnClickPendingIntent(R.id.button2, pi);
					
					AppWidgetManager.getInstance(this).updateAppWidget(widgetID, rv);
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					finish();
				}
			}
			
		}
		
		
	}

}
