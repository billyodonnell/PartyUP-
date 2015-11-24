package com.findyourparty.partyup.partyup;
import com.parse.*;
import java.util.Date;

/**
 * Created by billy_000 on 11/12/2015.
 */



@ParseClassName("Parties")
public class Parties extends ParseObject {
    private String details;
    private String title;
    private String address;
    private String date;
    private Boolean BYOB;
    //private Date partyDate;

    public Parties() {
        super();
    }


    public Parties(String details, String title, String address, String date, boolean BYOB) {
        super();
        setDetails(details);
        setTitle(title);
        setAddress(address);
        setPartyDate(date);
        setBYOB(BYOB);
       // setDate(partyDate);
    }

    public String getDetails() {
        return getString("details");
    }

    public String getTitle() {
        return getString("title");
    }

  //  public Date getDate() { return getDate("partyDate"); }

    public String getAddress() {
        return getString("address");
    }

    public String getPartyDate() {
        return getString("date");
    }

    public boolean getBYOB() {
        return getBoolean("BYOB");
    }
    public ParseUser getOwner() {
        return getParseUser("owner");
    }

//   public void setDate(Date value) { put("partyDate", value);}

    public void setDetails(String value) {
        put("details", value);
    }

    public void setTitle(String value) {
        put("title", value);
    }

    public void setAddress(String value) {
        put("address", value);
    }

    public void setPartyDate(String value) {
        put("date", value);
    }

    public void setBYOB(boolean value) {
        put("BYOB", value);
    }
    public void setOwner(ParseUser user) {
        put("owner", user);
    }

    //public String getUser() { return getString("user"); }

   // public void setUser(String value) {put("user", value);}
}

