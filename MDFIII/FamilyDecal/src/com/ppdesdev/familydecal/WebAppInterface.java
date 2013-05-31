/*
 * 	project		FamilyDecal
 * 
 * 	package		com.ppdesdev.familydecal
 * 
 * 	@author		patrickpowers
 * 
 * 	date		May 30, 2013
 * 
 */
package com.ppdesdev.familydecal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
	Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Connect to the email button on the webview */
    @JavascriptInterface
    public void showEmail() {
    	Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/html");
		intent.putExtra(Intent.EXTRA_EMAIL, "patrickpowers10@gmail.com");
		intent.putExtra(Intent.EXTRA_SUBJECT, "App Email");
		intent.putExtra(Intent.EXTRA_TEXT, "Please add me to future email updates.");
		mContext.startActivity(Intent.createChooser(intent, "Send Email"));
    }
    
    /** Connect to the call button on the webview */
    @JavascriptInterface
    public void placeCall() {
    	 
    	String	num = "407-340-7829";

    	String uri = "tel:" + num.trim() ;
    	Intent intent = new Intent(Intent.ACTION_DIAL);
    	intent.setData(Uri.parse(uri));
    	mContext.startActivity(intent);
    }
    
    
    
    

}
