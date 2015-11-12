package com.findyourparty.partyup.partyup;

/**
 * Created by billy_000 on 10/29/2015.
 */

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;

import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Parties.class);
        // Add your initialization code here
        Parse.initialize(this, "uMwiZTIJCVqhnSnRYWBv0u3mPTA4C1lJuywrEAko", "42sQjyzV6lqF5kzmb1oNoDgaI4PArhDoMbg2WywU");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }

}