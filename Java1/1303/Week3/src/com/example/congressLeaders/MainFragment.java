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
				/*
				getName(queryField.getText().toString());
				*/
				
				listener.onLeaderSearch(name);
			}
		});
		
		//More Info Button
		Button singleLeader = (Button) view.findViewById(R.id.moreInfoButton);
		singleLeader.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				listener.onDetailView();
				/*
				try{
					String firstName = jObject2.getString("first_name");
					String lastName = jObject2.getString("last_name");
					String fullName = firstName + " " + lastName;
					String chamber = jObject2.getString("chamber");
					String party = jObject2.getString("party");
					String stateName = jObject2.getString("state_name");
					String birthday = jObject2.getString("birthday");
					String phone = jObject2.getString("phone");
					String contactForm = jObject2.getString("contact_form");
					String gender = jObject2.getString("gender");
					String officeAddress = jObject2.getString("office");
					String fax = jObject2.getString("fax");
					String website = jObject2.getString("website");
					
					Intent i = new Intent(getApplicationContext(), SingleLeaderInfo.class);
		              // sending data
		              i.putExtra("name", fullName);
		              i.putExtra("chamber", chamber);
		              i.putExtra("party", party);
		              i.putExtra("state", stateName);
		              i.putExtra("birthday", birthday);
		              i.putExtra("phone", phone);
		              i.putExtra("contact Form", contactForm);
		              i.putExtra("gender", gender);
		              i.putExtra("office", officeAddress);
		              i.putExtra("fax", fax);
		              i.putExtra("website", website);
		              startActivityForResult(i, 0);
					
				}catch(JSONException e){
					Log.e("JSON Error", e.toString());
				}
	            */  
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
