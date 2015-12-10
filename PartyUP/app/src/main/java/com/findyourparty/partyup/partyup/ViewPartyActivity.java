package com.findyourparty.partyup.partyup;

/**
 * Created by Trevor on 12/2/15.
 */

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.DatePicker;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import android.app.Dialog;
import android.os.Message;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.util.List;


public class ViewPartyActivity extends Activity {

    Button backBtn;
    CheckBox byob;
    String titletxt;
    String datetxt;
    String addresstxt;
    String detailstxt;
    int year;
    int monthOfYear;
    int dayOfMonth;
    Boolean byobBool = false;
    TextView title;
    TextView date;
    TextView address;
    TextView details;
    //    TextView datePick;
//    static final int DATE_DIALOG_ID = 0;
//    DatePicker partyDate;
//    Date myDate;
//    DatePickerDialog datePickerDialog;
//    DateFormat dateFormatter;
    int partyid;


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



//    public Address address;
//    public long partyid;


//    String str = getIntent.getExtras().getString("mystring");<<get string in second class

    //Intent intentExtras = getIntent();
//    partyid = getIntent.getExtras.getLongExtra("id", id);



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the view from xml
        setContentView(R.layout.view_party);
        // Locate EditTexts in xml
        title = (TextView) findViewById(R.id.title);
//        datePick = (TextView) findViewById(R.id.date);
        address = (TextView) findViewById(R.id.address);
        details = (TextView) findViewById(R.id.details);
        backBtn = (Button) findViewById(R.id.back);
        date = (TextView) findViewById(R.id.date);
        //byob = (CheckBox) findViewById(R.id.byob);
        //partyDate = (DatePicker) findViewById(R.id.partyDate);
        // Retrieve the text entered from the EditText


//        int Id = (int)partyid;

        Intent callingIntent = getIntent();
//        partyid = callingIntent.getIntExtra("position", partyid);
//        title.setText(titleList.get(partyid));

        title.setText(callingIntent.getStringExtra("title"));
        address.setText(callingIntent.getStringExtra("address"));
        details.setText(callingIntent.getStringExtra("details"));
//        date.setText(callingIntent.getStringExtra("date"));
        date.setText("3-12-15");




        backBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        ViewPartyActivity.this,
                        HomeScreenActivity.class);
                startActivity(intent);
                finish();
            }

        });

    }
}