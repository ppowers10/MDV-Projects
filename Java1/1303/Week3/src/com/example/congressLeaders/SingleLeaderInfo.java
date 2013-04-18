package com.example.congressLeaders;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SingleLeaderInfo extends Activity {
	
	CheckBox goodLeader;
	String passedString;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.detail_layout_frag);
        
        TextView leaderName = (TextView) findViewById(R.id.nameID);
        TextView leaderChamber = (TextView) findViewById(R.id.chamberID);
        TextView leaderState = (TextView) findViewById(R.id.stateID);
        TextView leaderParty = (TextView) findViewById(R.id.partyID);
        TextView leaderBirth = (TextView) findViewById(R.id.birthID);
        TextView leaderAddress = (TextView) findViewById(R.id.addressID);
        TextView leaderPhone = (TextView) findViewById(R.id.phoneID);
        TextView leaderFax = (TextView) findViewById(R.id.faxID);
        TextView leaderWeb = (TextView) findViewById(R.id.websiteID);
        TextView leaderContact = (TextView) findViewById(R.id.contactID);
   	 
        Intent i = getIntent();
        // intent data
        String name = i.getStringExtra("name");
        String chamber = i.getStringExtra("chamber");
        String party = i.getStringExtra("party");
        String state = i.getStringExtra("state");
        String birthday = i.getStringExtra("birthday");
        String phone = i.getStringExtra("phone");
        String contactForm = i.getStringExtra("contact Form");
        String office = i.getStringExtra("office");
        String fax = i.getStringExtra("fax");
        String website = i.getStringExtra("website");
        // displaying truck name
        leaderName.setText(name);
        leaderChamber.setText(chamber);
        leaderState.setText(state);
        leaderParty.setText(party);
        leaderBirth.setText(birthday);
        leaderAddress.setText(office);
        leaderPhone.setText(phone);
        leaderFax.setText(fax);
        leaderWeb.setText(website);
        leaderContact.setText(contactForm);
        
        goodLeader = (CheckBox) this.findViewById(R.id.checkID);
        
        Button goodButton = (Button) this.findViewById(R.id.checkButton);
        
        goodButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(goodLeader.isChecked()){
					passedString = "This is a good Leader";
					Intent returnIntent = new Intent();
					returnIntent.putExtra("response", passedString);
					setResult(RESULT_OK, returnIntent);
					finish();
				}else {
					Intent returnIntent = new Intent();
					setResult(RESULT_CANCELED, returnIntent);
					finish();
				}
			}
		});
}
	
}
