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
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreatePartyActivity_2 extends Activity {

    Button CreatePartyBtn;
    Button byob;
    String titletxt;
    String datetxt;
    String locationtxt;
    String detailstxt;
    EditText title;
    EditText date;
    EditText location;
    EditText details;


    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the view from loginsignup.xml
        setContentView(R.layout.create_party_2);
        // Locate EditTexts in loginsignup.xml
        title = (EditText) findViewById(R.id.title);
        date = (EditText) findViewById(R.id.date);
        location = (EditText) findViewById(R.id.location);
        details = (EditText) findViewById(R.id.details);
        CreatePartyBtn = (Button) findViewById(R.id.createparty2);
        byob = (Button) findViewById(R.id.byob);

        setContentView(R.layout.create_party_2); // twice?

        // Retrieve the text entered from the EditText
        titletxt = title.getText().toString();
        datetxt = date.getText().toString();
        locationtxt = location.getText().toString();
        detailstxt = details.getText().toString();


        CreatePartyBtn.setOnClickListener
                (new OnClickListener() {
                    public void onClick(View arg0) {
                        // send to Register Activity
                        Intent intent = new Intent(
                                CreatePartyActivity_2.this,
                                CreatePartyActivity.class);
                        startActivity(intent);
                        finish();
                    }

                });

    }
}