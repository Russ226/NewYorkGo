package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tarek on 4/27/2018.
 */

public class Tennis {

    @SerializedName("Prop_Name")
    private String propName;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("courts")
    private String courts;

    @SerializedName("Indoor_Outdoor")
    private String indoorOutdoor;

    @SerializedName("Tennis_Type")
    private String tennisType;

    @SerializedName("Accessible")
    private String accessible;

    @SerializedName("Info")
    private String info;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lon")
    private String lon;

    public Tennis(String propName, String name, String location, String phone, String courts, String indoorOutdoor, String tennisType, String accessible, String info, String lat, String lon) {
        this.propName = propName;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.courts = courts;
        this.indoorOutdoor = indoorOutdoor;
        this.tennisType = tennisType;
        this.accessible = accessible;
        this.info = info;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourts() {
        return courts;
    }

    public void setCourts(String courts) {
        this.courts = courts;
    }

    public String getIndoorOutdoor() {
        return indoorOutdoor;
    }

    public void setIndoorOutdoor(String indoorOutdoor) {
        this.indoorOutdoor = indoorOutdoor;
    }

    public String getTennisType() {
        return tennisType;
    }

    public void setTennisType(String tennisType) {
        this.tennisType = tennisType;
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
