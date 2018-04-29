package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by russ on 4/27/18.
 */

public class Handball extends Recreation{
    @SerializedName("prop_ID")
    private String propId;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Num_of_Courts")
    private String numOfCourts;

    private Double distance;

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

    public String getNumOfCourts() {
        return numOfCourts;
    }

    public void setNumOfCourts(String numOfCourts) {
        this.numOfCourts = numOfCourts;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public static Comparator<Handball> COMPARE_BY_DISTANCE = new Comparator<Handball>() {
        public int compare(Handball one, Handball other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
