package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by tarek on 4/27/2018.
 */

public class Hiking extends Recreation{

    @SerializedName("Prop_ID")
    private String propID;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Park_Name")
    private String parkName;

    @SerializedName("Length")
    private String length;

    @SerializedName("Difficulty")
    private String difficulty;

    @SerializedName("Other_Details")
    private String otherDetails;

    @SerializedName("Accessible")
    private String accessible;

    @SerializedName("Limited_Access")
    private String limitedAccess;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lon")
    private String lon;

    private Double distance;

    public Hiking(String propID, String name, String location, String parkName, String length, String difficulty, String otherDetails, String accessible, String limitedAccess, String lat, String lon) {
        this.propID = propID;
        this.name = name;
        this.location = location;
        this.parkName = parkName;
        this.length = length;
        this.difficulty = difficulty;
        this.otherDetails = otherDetails;
        this.accessible = accessible;
        this.limitedAccess = limitedAccess;
        this.lat = lat;
        this.lon = lon;
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

    public String getParkName() {
        return parkName;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getAddress1() {
        return null;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }

    public String getLimitedAccess() {
        return limitedAccess;
    }

    public void setLimitedAccess(String limitedAccess) {
        this.limitedAccess = limitedAccess;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public static Comparator<Hiking> COMPARE_BY_DISTANCE = new Comparator<Hiking>() {
        public int compare(Hiking one, Hiking other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
