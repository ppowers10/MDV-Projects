package com.ppdesdev.familydecal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.sax.StartElementListener;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
	Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showEmail() {
    	Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/html");
		intent.putExtra(Intent.EXTRA_EMAIL, "patrickpowers10@gmail.com");
		intent.putExtra(Intent.EXTRA_SUBJECT, "App Email");
		intent.putExtra(Intent.EXTRA_TEXT, "Please add me to future email updates.");
		mContext.startActivity(Intent.createChooser(intent, "Send Email"));
    }
    
    /** Show a toast from the web page */
    @JavascriptInterface
    public void placeCall() {
    	 String	num = "407-340-7829";

    	 String uri = "tel:" + num.trim() ;
    	 Intent intent = new Intent(Intent.ACTION_DIAL);
    	 intent.setData(Uri.parse(uri));
    	 mContext.startActivity(intent);
    }
    
    
    
    

}
