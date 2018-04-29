package com.tareksaidee.newyorkgo.DTO;

/**
 * Created by tarek on 4/29/2018.
 */

public class Bookmark {

    private String name;

    private String detailsID;

    public Bookmark(String name, String detailsID) {
        this.name = name;
        this.detailsID = detailsID;
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
}
