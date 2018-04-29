package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

public class ZooAqu extends Recreation{

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Phone_Num")
    private String phoneNum;

    @SerializedName("Prop_ID")
    private String propID;

    public ZooAqu(String name, String location, String phoneNum, String propID) {
        this.name = name;
        this.location = location;
        this.phoneNum = phoneNum;
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

    @Override
    public String getParkName() {
        return null;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getAddress1() {
        return null;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPropID() {
        return propID;
    }

    public void setPropID(String propID) {
        this.propID = propID;
    }
}