package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 4/27/18.
 */

public class Handball {
    @SerializedName("prop_ID")
    private String propId;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Num_of_Courts")
    private String numOfCourts;

    public Handball(String propId, String name, String location, String numOfCourts) {
        this.propId = propId;
        this.name = name;
        this.location = location;
        this.numOfCourts = numOfCourts;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
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

    public String getNumOfCourts() {
        return numOfCourts;
    }

    public void setNumOfCourts(String numOfCourts) {
        this.numOfCourts = numOfCourts;
    }
}
