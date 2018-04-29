package com.tareksaidee.newyorkgo.DTO;

import java.util.Comparator;

/**
 * Created by tarek on 4/29/2018.
 */

public class Bookmark {

    private String name;

    private String detailsID;

    private String className;

    private Double distance;

    private String address;

    private String location;

    public Bookmark(String name, String detailsID, String className, String address) {
        this.name = name;
        this.detailsID = detailsID;
        this.className = className;
        this.address = address;
        location = "350 5th Ave";
    }

    public Bookmark() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailsID() {
        return detailsID;
    }

    public void setDetailsID(String detailsID) {
        this.detailsID = detailsID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public static Comparator<Bookmark> COMPARE_BY_DISTANCE = new Comparator<Bookmark>() {
        public int compare(Bookmark one, Bookmark other) {
            return one.distance.compareTo(other.distance);
        }
    };

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
