/*
 * 	project		CongressLeaders
 * 
 * 	package		com.example.congressLeaders
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Apr 18, 2013
 * 
 */
package com.example.congressLeaders;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class SingleLeaderFragment extends Fragment {
	
	private SingleListeners listener2;
	
	public interface SingleListeners {
		public void onDoneClick(CheckBox goodLeader);
	}
	
	CheckBox goodLeader;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		//create the inflater for the xml
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.detail_layout, container, false);
		
		//set up check box and button click when done
        goodLeader = (CheckBox) view.findViewById(R.id.checkID);
        Button goodButton = (Button) view.findViewById(R.id.checkButton);
        goodButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener2.onDoneClick(goodLeader);
			}
		});
        
		return view;
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			listener2 = (SingleListeners) activity;
		}catch (ClassCastException e){
			throw new ClassCastException(activity.toString() + "must implement MainListener");
		}
	}
}
