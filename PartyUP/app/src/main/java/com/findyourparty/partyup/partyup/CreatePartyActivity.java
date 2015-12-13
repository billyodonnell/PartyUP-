package com.findyourparty.partyup.partyup;

/**
 * Created by Trevor on 11/2/15.
 */

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.DatePicker;
import android.widget.TextView;
import com.parse.ParseUser;
import android.app.Dialog;
import android.os.Message;
import android.os.Handler;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
public class CreatePartyActivity extends Activity {

    Button CreatePartyBtn;
    Button BackBtn;
    CheckBox byob;
    String titletxt;
    String datetxt;
    String addresstxt;
    String detailstxt;
    int year;
    int monthOfYear;
    int dayOfMonth;
    Boolean byobBool = false;
    EditText title;
    EditText date;
    EditText address;
    EditText details;
    TextView datePick;
    static final int DATE_DIALOG_ID = 0;
    DatePicker partyDate;
    Date myDate;
    DatePickerDialog datePickerDialog;
    DateFormat dateFormatter;

    /* called when the activity is first created. */
    public DatePickerDialog.OnDateSetListener dateOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            datePick.setText(new StringBuilder().append(selectedDay).append("-").append(selectedMonth).append("-").append(selectedYear));
        }
    };
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, dateOnDateSetListener, year, monthOfYear, dayOfMonth);
        }
        return null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the view from xml
        setContentView(R.layout.create_party);
        // Locate EditTexts in xml
        title = (EditText) findViewById(R.id.title);
        datePick = (TextView) findViewById(R.id.date);
        address = (EditText) findViewById(R.id.address);
        details = (EditText) findViewById(R.id.details);
        CreatePartyBtn = (Button) findViewById(R.id.createparty);
        BackBtn = (Button) findViewById(R.id.back);
        byob = (CheckBox) findViewById(R.id.byob);
        //partyDate = (DatePicker) findViewById(R.id.partyDate);
        // Retrieve the text entered from the EditText
        datePick.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                monthOfYear = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                showDialog(DATE_DIALOG_ID);

            }
        });

        BackBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(
                        CreatePartyActivity.this,
                        HomeScreenActivity.class);
                startActivity(intent);
                finish();
            }

        });
        CreatePartyBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                detailstxt = details.getText().toString();
                titletxt = title.getText().toString();
                addresstxt = address.getText().toString();
                datetxt = datePick.getText().toString();

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
                if (addresstxt != "") {
                    userParty.setAddress(addresstxt);
                }
                if (datetxt != "") {
                    userParty.setPartyDate(datetxt);
                }
                userParty.setBYOB(byobBool);
                //userParty.setUser(ParseUser.getCurrentUser().getUsername());
                userParty.setOwner(ParseUser.getCurrentUser());
                userParty.saveInBackground();
                Toast.makeText(
                        getApplicationContext(),
                        "Party has been created!",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(
                        CreatePartyActivity.this,
                        HomeScreenActivity.class);
                startActivity(intent);
                finish();
            }

        });

    }
}