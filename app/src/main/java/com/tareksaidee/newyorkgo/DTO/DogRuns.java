package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by tarek on 4/27/2018.
 */

public class DogRuns extends Recreation{

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

    private Double distance;


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

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public String getParkName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String getAddress1() {
        return null;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public static Comparator<DogRuns> COMPARE_BY_DISTANCE = new Comparator<DogRuns>() {
        public int compare(DogRuns one, DogRuns other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
