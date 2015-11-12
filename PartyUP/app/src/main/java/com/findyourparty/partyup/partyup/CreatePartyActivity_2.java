package com.findyourparty.partyup.partyup;

/**
 * Created by Trevor on 11/2/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.ParseObject;
import com.parse.SignUpCallback;

public class CreatePartyActivity_2 extends Activity {

    Button CreatePartyBtn;
    CheckBox byob;
    String titletxt;
    String datetxt;
    String locationtxt;
    String detailstxt;
    Boolean byobBool = false;
    EditText title;
    EditText date;
    EditText location;
    EditText details;


    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the view from xml
        setContentView(R.layout.create_party_2);
        // Locate EditTexts in xml
        title = (EditText) findViewById(R.id.title);
        date = (EditText) findViewById(R.id.date);
        location = (EditText) findViewById(R.id.location);
        details = (EditText) findViewById(R.id.details);
        CreatePartyBtn = (Button) findViewById(R.id.createparty2);
        byob = (CheckBox) findViewById(R.id.byob);


        // Retrieve the text entered from the EditText


        CreatePartyBtn.setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        // Retrieve the text entered from the EditText
                        detailstxt = details.getText().toString();
                        titletxt = title.getText().toString();
                        locationtxt = location.getText().toString();
                        datetxt = date.getText().toString();
                        if (byob.isChecked()){
                            byobBool = true;
                        }
                        else {
                            byobBool = false;
                        }

                            Parties userParty = new Parties();
                            if (detailstxt != "") {
                                userParty.setDetails(detailstxt);
                            }
                            if (titletxt != "") {
                                userParty.setTitle(titletxt);
                            }
                            if (locationtxt != "") {
                                userParty.setLocation(locationtxt);
                            }
                            if (datetxt != "") {
                                userParty.setPartyDate(datetxt);
                            }
                            userParty.setBYOB(byobBool);
                            userParty.setOwner(ParseUser.getCurrentUser());
                            userParty.saveInBackground();
                            Intent intent = new Intent(
                                    CreatePartyActivity_2.this,
                                    CreatePartyActivity.class);
                            startActivity(intent);
                            finish();
                        }

                });

    }
}