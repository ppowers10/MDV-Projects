/*
 * 	project		CongressInfo
 * 
 * 	package		com.ppdesdev.congress
 * 
 * 	@author		patrickpowers
 * 
 * 	date		May 2, 2013
 * 
 */
package com.ppdesdev.congress;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailView extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        this.setContentView(R.layout.detail_view);
        
        //set up text view
        TextView name = (TextView) findViewById(R.id.leadername);
        
        Intent i = getIntent();
        // intent data
        String firstName = i.getStringExtra("firstName");
        String lastName = i.getStringExtra("lastName");
        String fullName = firstName + " " + lastName;
        
        name.setText(fullName);
        
        //set up web intent
        Button congressWeb = (Button) findViewById(R.id.websitelink);
        congressWeb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
							
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.congress.gov"));
				startActivity(browserIntent);
			}
		});
        
	}
}
