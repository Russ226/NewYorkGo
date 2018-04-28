package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

public class Park {
    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Zip")
    private int zipCode;

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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getPropID() {
        return propID;
    }

    public void setPropID(int propID) {
        this.propID = propID;
    }

    public Park(String name, String location, int zipCode, int propID) {
        this.name = name;
        this.location = location;

        this.zipCode = zipCode;
        this.propID = propID;
    }

    @SerializedName("Prop_ID")
    private int propID;
}
