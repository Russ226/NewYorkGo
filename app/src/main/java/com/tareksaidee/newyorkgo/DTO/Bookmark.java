package com.tareksaidee.newyorkgo.DTO;

/**
 * Created by tarek on 4/29/2018.
 */

public class Bookmark {

    private String name;

    private String detailsID;

    private String className;

    public Bookmark(String name, String detailsID, String className) {
        this.name = name;
        this.detailsID = detailsID;
        this.className = className;
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
}
