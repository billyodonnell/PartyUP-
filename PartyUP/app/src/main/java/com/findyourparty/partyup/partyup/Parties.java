package com.findyourparty.partyup.partyup;
import com.parse.*;

/**
 * Created by billy_000 on 11/12/2015.
 */



@ParseClassName("Parties")
public class Parties extends ParseObject {
    private String details;
    private String title;
    private String location;
    private String date;
    private Boolean BYOB;

    public Parties() {
        super();
    }


    public Parties(String details, String title, String location, String date, boolean BYOB) {
        super();
        setDetails(details);
        setTitle(title);
        setLocation(location);
        setPartyDate(date);
        setBYOB(BYOB);
    }

    public String getDetails() {
        return getString("details");
    }

    public String getTitle() {
        return getString("title");
    }

    public String getLocation() {
        return getString("location");
    }

    public String getPartyDate() {
        return getString("date");
    }

    public boolean getBYOB() {
        return getBoolean("BYOB");
    }

    public void setDetails(String value) {
        put("details", value);
    }

    public void setTitle(String value) {
        put("title", value);
    }

    public void setLocation(String value) {
        put("location", value);
    }

    public void setPartyDate(String value) {
        put("date", value);
    }

    public void setBYOB(boolean value) {
        put("BYOB", value);
    }

    public ParseUser getUser() {
        return getParseUser("owner");
    }

    public void setOwner(ParseUser user) {
        put("owner", user);
    }
}

