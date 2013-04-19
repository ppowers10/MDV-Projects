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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainFragment extends Fragment {

	private MainListeners listener;
	
	public interface MainListeners {
		public void onLeaderSearch(String name);
		public void onDetailView();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.layout, container, false);
		
		
		Button queryButton = (Button) view.findViewById(R.id.button1);		
		//on click for the query
		queryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
							
				EditText queryField = (EditText) getActivity().findViewById(R.id.editText1);
				Log.i("Click Handler", queryField.getText().toString());
				String name = queryField.getText().toString();
				
				listener.onLeaderSearch(name);
			}
		});
		
		//More Info Button
		Button singleLeader = (Button) view.findViewById(R.id.moreInfoButton);
		singleLeader.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onDetailView();
			}
		});
		
		return view;
	};
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			listener = (MainListeners) activity;
		}catch (ClassCastException e){
			throw new ClassCastException(activity.toString() + "must implement MainListener");
		}
	}
}
