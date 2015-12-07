package com.findyourparty.partyup.partyup;

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
import android.widget.ImageButton;

public class HomeScreenActivity extends Activity {


    ImageButton logoutBtn;
    ImageButton addPartyBtn;
    ImageButton searchBtn;
    ImageButton nearbyPartiesBtn;
    ImageButton profileBtn;
    TextView bruhBtn; // for the list view

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from home_screen.xml
        setContentView(R.layout.home_screen);

        // Locate Buttons from home_screen.xml
        addPartyBtn = (ImageButton) findViewById(R.id.addPartyBtn);
        searchBtn = (ImageButton) findViewById(R.id.searchButtonBtn);
        nearbyPartiesBtn = (ImageButton) findViewById(R.id.nearbyPartiesBtn);
        profileBtn = (ImageButton) findViewById(R.id.profileBtn);
        logoutBtn = (ImageButton) findViewById(R.id.logoutBtn);

        // Create Button Click Listener
        addPartyBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        HomeScreenActivity.this,
                        CreatePartyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        searchBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        HomeScreenActivity.this,
                        CreatePartyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        nearbyPartiesBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        HomeScreenActivity.this,
                        PartyMapActivity.class);
                startActivity(intent);
                finish();
            }
        });
        profileBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        HomeScreenActivity.this,
                        Welcome.class);
                startActivity(intent);
                finish();
            }
        });

        logoutBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        HomeScreenActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        /* for the ListView */
        bruhBtn = (TextView) findViewById(R.id.bruh);

        bruhBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        HomeScreenActivity.this,
                        ViewPartyActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}