package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tarek on 4/27/2018.
 */

public class DogRuns {

    @SerializedName("Prop_ID")
    private String propID;

    @SerializedName("Name")
    private String name;

    @SerializedName("Address")
    private String address;

    @SerializedName("DogRuns_Type")
    private String dogRunsType;

    @SerializedName("Accessible")
    private String accessible;

    @SerializedName("Notes")
    private String notes;


    public DogRuns(String propID, String name, String address, String dogRunsType, String accessible, String notes) {
        this.propID = propID;
        this.name = name;
        this.address = address;
        this.dogRunsType = dogRunsType;
        this.accessible = accessible;
        this.notes = notes;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDogRunsType() {
        return dogRunsType;
    }

    public void setDogRunsType(String dogRunsType) {
        this.dogRunsType = dogRunsType;
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
