package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class BasketballCourt extends Recreation{
    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Num_of_Courts")
    private int numCourts;

    @SerializedName("Accessible")
    private String wheelchair;

    private Double distance;

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

    public int getNumCourts() {
        return numCourts;
    }

    public void setNumCourts(int numCourts) {
        this.numCourts = numCourts;
    }

    public String getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(String wheelchair) {
        this.wheelchair = wheelchair;
    }

    public BasketballCourt(String name, String location, int numCourts, String wheelchair) {

        this.name = name;
        this.location = location;
        this.numCourts = numCourts;
        this.wheelchair = wheelchair;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public static Comparator<BasketballCourt> COMPARE_BY_DISTANCE = new Comparator<BasketballCourt>() {
        public int compare(BasketballCourt one, BasketballCourt other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
