package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;
import com.tareksaidee.newyorkgo.sorter.DistanceAndLocation;

import java.util.Comparator;

/**
 * Created by russ on 4/27/18.
 */

public class BBQ extends Recreation{
    Double distance;

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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Double getDistance() {
        return distance;
    }

    public static Comparator<BBQ> COMPARE_BY_DISTANCE = new Comparator<BBQ>() {
        public int compare(BBQ one, BBQ other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
