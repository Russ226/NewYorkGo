package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 4/27/18.
 */

public class NaturePreserves extends Recreation{
    @SerializedName("ParkID")
    private String parkId;

    @SerializedName("ParkName")
    private String parkName;

    @SerializedName("SanctuaryName")
    private String sanctuaryName;

    @SerializedName("Borough")
    private String borough;

    @SerializedName("Acres")
    private String acres;

    @SerializedName("Directions")
    private String directions;

    @SerializedName("Description")
    private String description;

    @SerializedName("HabitatType")
    private String habitatType;

    public NaturePreserves(String parkId, String parkName, String sanctuaryName, String borough, String acres, String directions, String description, String habitatType) {
        this.parkId = parkId;
        this.parkName = parkName;
        this.sanctuaryName = sanctuaryName;
        this.borough = borough;
        this.acres = acres;
        this.directions = directions;
        this.description = description;
        this.habitatType = habitatType;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLocation() {
        return null;
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

    public String getSanctuaryName() {
        return sanctuaryName;
    }

    public void setSanctuaryName(String sanctuaryName) {
        this.sanctuaryName = sanctuaryName;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getAcres() {
        return acres;
    }

    public void setAcres(String acres) {
        this.acres = acres;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHabitatType() {
        return habitatType;
    }

    public void setHabitatType(String habitatType) {
        this.habitatType = habitatType;
    }
}
