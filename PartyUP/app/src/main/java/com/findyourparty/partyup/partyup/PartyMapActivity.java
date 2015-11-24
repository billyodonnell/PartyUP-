package com.findyourparty.partyup.partyup;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
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
import android.widget.Toast;
import java.io.IOException;

public class PartyMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    public ArrayList<String> ourAddresses;
    public List<Address> addressList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParseQuery<ParseObject> partyData = new ParseQuery<ParseObject>("Parties");
        partyData.selectKeys(Arrays.asList("address"));
        partyData.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> addresses, ParseException e) {
                if (e == null) {
                    ArrayList<String> addressTexts = new ArrayList<String>();
                    for (ParseObject address : addresses) {
                        addressTexts.add(address.getString("address"));
                    }
                    ourAddresses = addressTexts;
                    Toast.makeText(getApplicationContext(),
                            "query error: " + e,
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Successful.", Toast.LENGTH_LONG).show();
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
    for (int i = 0; i < ourAddresses.size(); i++) {
        try {
            String myString;
            myString = ourAddresses.get(i);
            addressList = geocoder.getFromLocationName(myString, 1);
            if (addressList != null && addressList.size() > 0) {
                Address address = addressList.get(0);

            }
        } catch(IOException ie) {
            ie.printStackTrace();
        }
        }
        for (int i = 0; i < addressList.size(); i++)
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(addressList.get(i).getLatitude(), addressList.get(i).getLongitude())));
     }

}

