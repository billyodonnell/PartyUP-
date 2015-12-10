package com.findyourparty.partyup.partyup;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Marker;
import android.location.Geocoder;
import android.util.Log;
import android.location.Address;
import java.util.List;
import java.util.*;
import java.util.Locale;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.FindCallback;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;


public class PartyMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button backBtn;
    public List<String> ourAddresses;
    public List<String> ourTitles;
    public List<String> ourDetails;
    public List<Address> addressList;
    public Address address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        backBtn = (Button) findViewById(R.id.back);
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
                } else {
                    Toast.makeText(getApplicationContext(),
                            "query error: " + e,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        setContentView(R.layout.partymapactivity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMap().setMyLocationEnabled(true);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        if (ourAddresses != null){
            ArrayList<Marker> markers = new ArrayList<Marker>();
            for (int i = 0; i < ourAddresses.size(); i++) {
        try {
            String myString;
            myString = ourAddresses.get(i);
            addressList = geocoder.getFromLocationName(myString, 1);
            if (addressList != null && addressList.size() > 0) {
                address = addressList.get(0);
                Marker marker = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(address.getLatitude(), address.getLongitude())));
                markers.add(marker);
            }
            for (int j = 0; j < markers.size(); j++){
                Marker myMarker = markers.get(j);
                myMarker.setTitle(ourTitles.get(j));
                myMarker.setSnippet(ourDetails.get(j));
                myMarker.showInfoWindow();
            }


        } catch(IOException ie) {
            ie.printStackTrace();
        }}}
    }


}

