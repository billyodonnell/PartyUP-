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

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
/**
 * Created by billy_000 on 11/4/2015.
 */
public class LoginActivity extends Activity {


    Button loginbutton;
    TextView registertextbutton;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from loginsignup.xml
        setContentView(R.layout.login);
        // Locate EditTexts in loginsignup.xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        // Get the view from login.xml
        setContentView(R.layout.login);
        loginbutton = (Button) findViewById(R.id.login);
        registertextbutton = (TextView) findViewById(R.id.register_from_logintxt);
        registertextbutton.setPaintFlags(registertextbutton.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        loginbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();
                ParseUser.logInInBackground(usernametxt, passwordtxt,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                user = ParseUser.getCurrentUser();
                                if (user != null) {
                                    // If user exist and authenticated, send user to CreatePartyActivity.class
                                    // Name needs to change obviously
                                    Intent intent = new Intent(
                                            LoginActivity.this,
                                            HomeScreenActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),
                                            "Successfully Logged in",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    int error = e.getCode();

                                    Toast.makeText(
                                        getApplicationContext(),
                                        "No such user exist, please register!",
                                        Toast.LENGTH_LONG).show();
                            }
                            }
                        });
            }
        });
        registertextbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // send to Register Activity
                Intent intent = new Intent(
                        LoginActivity.this,
                        SignupActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}