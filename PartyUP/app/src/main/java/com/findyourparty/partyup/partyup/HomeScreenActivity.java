package com.findyourparty.partyup.partyup;

/* created by trevor/billy/zack */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

import com.google.android.gms.maps.SupportMapFragment;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class HomeScreenActivity extends Activity {


    ImageButton logoutBtn;
    ImageButton addPartyBtn;
    ImageButton nearbyPartiesBtn;
    ImageButton profileBtn;
    TextView bruhBtn; // for the list view

    ListView partylist;
    public ArrayAdapter<String> adapter;
    public ArrayList<String> arrayList;

    public List<String> ourAddresses;
    public List<String> ourTitles;
    public List<String> ourDetails;
    public List<Address> addressList;
    public ArrayList<String> titleList;
    public ArrayList<String> addressList2;
    public ArrayList<String> detailsList;
    public ArrayList<String> dateList;
    public Address address;

    String titleSTRING;
    String addressSTRING;
    String detailsSTRING;
    String dateSTRING;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from home_screen.xml
        setContentView(R.layout.home_screen);

        // Locate Buttons from home_screen.xml
        addPartyBtn = (ImageButton) findViewById(R.id.addPartyBtn);
        nearbyPartiesBtn = (ImageButton) findViewById(R.id.nearbyPartiesBtn);
        profileBtn = (ImageButton) findViewById(R.id.profileBtn);
        logoutBtn = (ImageButton) findViewById(R.id.logoutBtn);


        partylist = (ListView) findViewById(R.id.partylistView);



        ParseQuery<ParseObject> partyData = new ParseQuery<ParseObject>("Parties");
        partyData.selectKeys(Arrays.asList("address", "title", "details"));
        partyData.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> addresses, ParseException e) {
                if (e == null) {
                    List<String> addressTexts = new ArrayList<String>();
                    List<String> titleTexts = new ArrayList<String>();
                    List<String> detailsTexts = new ArrayList<String>();
                    for (ParseObject address : addresses) {
                        addressTexts.add(address.getString("address"));
                        titleTexts.add(address.getString("title"));
                        detailsTexts.add(address.getString("details"));
                    }
                    ourAddresses = addressTexts;
                    ourTitles = titleTexts;
                    ourDetails = detailsTexts;
                    Toast.makeText(getApplicationContext(), "Successful.", Toast.LENGTH_LONG).show();


                    arrayList = new ArrayList<String>();
                    titleList = new ArrayList<String>();
                    addressList2 = new ArrayList<String>();
                    detailsList = new ArrayList<String>();
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);

                    for (ParseObject address : addresses) {
                        arrayList.add(address.getString("title"));
                        titleList.add(address.getString("title"));
                        addressList2.add(address.getString("address"));
                        detailsList.add(address.getString("details"));
//                        dateList.add(address.getString("date"));
                    }
                    partylist.setAdapter(adapter);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "query error: " + e,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        partylist.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(
                        HomeScreenActivity.this,
                        ViewPartyActivity.class);


                titleSTRING = titleList.get(position);
                addressSTRING = addressList2.get(position);
                detailsSTRING = detailsList.get(position);
//                dateSTRING = dateList.get(position);

//                intent = arrayList.get(position);
//                intent.putExtra("position", position);

                intent.putExtra("title", titleSTRING);
                intent.putExtra("address", addressSTRING);
                intent.putExtra("details", detailsSTRING);
//                intent.putExtra("date", dateSTRING);


                startActivity(intent);
                finish();
            }
        });

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
//                        ProfileActivity.class);
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
    }
}