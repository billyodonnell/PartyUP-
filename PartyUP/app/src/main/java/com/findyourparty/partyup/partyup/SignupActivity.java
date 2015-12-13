package com.findyourparty.partyup.partyup;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
/**
 * Created by billy_000 on 11/4/2015.
 */
public class SignupActivity extends Activity{

    Button signup;
    String usernametxt;
    String passwordtxt;
    String emailtxt;
    EditText password;
    EditText username;
    EditText email;
    TextView signuptologinbutton;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from loginsignup.xml
        setContentView(R.layout.signup);
        // Locate EditTexts in loginsignup.xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        signuptologinbutton = (TextView) findViewById(R.id.signuptologinbutton);
        signuptologinbutton.setPaintFlags(signuptologinbutton.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        // Locate Buttons in signup.xml
        signup = (Button) findViewById(R.id.signup);
        ParseUser currentUser;
        currentUser = ParseUser.getCurrentUser();
        if (currentUser != null)
            currentUser.logOut();
        // Login Button Click Listener
        signuptologinbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // send to Register Activity
                Intent intent = new Intent(
                        SignupActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }

        });
        // Sign up Button Click Listener
        signup.setOnClickListener(new OnClickListener() {
            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();
                emailtxt = email.getText().toString();

                // Force user to fill up the form
                if (usernametxt.equals("") || passwordtxt.equals("") || emailtxt.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();
                }
                    else if (!isEmailValid(emailtxt)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter a valid .edu email address",
                            Toast.LENGTH_LONG).show();
                }
                 else {
                    // Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.setUsername(usernametxt);
                    user.setPassword(passwordtxt);
                    user.setEmail(emailtxt);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(
                                                SignupActivity.this,
                                                LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });
                }

            }
        });

    }
}
