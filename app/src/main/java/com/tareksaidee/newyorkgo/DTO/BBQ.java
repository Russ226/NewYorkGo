package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 4/27/18.
 */

public class BBQ {
    @SerializedName("Prop_ID")
    private String propID;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    public BBQ(String propID, String name, String location) {
        this.propID = propID;
        this.name = name;
        this.location = location;
    }

    public String getPropID() {
        return propID;
    }

    public void setPropID(String propID) {
        this.propID = propID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
