package com.findyourparty.partyup.partyup;

/**
 * Created by Trevor on 11/2/15.
 */

import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;



public class CreatePartyActivity extends Activity {

    // Declare Variables
    Button createpartybutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view to create_party.xml
        setContentView(R.layout.create_party);
        // Locate Buttons from create_party.xml
        createpartybutton = (Button) findViewByID(R.id.createparty);

        // Login Button Click Listener
        createpartybutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0){
                Intent intent = new Intent(
                        CreatePartyActivity.this,
                        CreatePartyActivity_2.class);
                startActivity(intent);
                finish();
            }



        }




}





















