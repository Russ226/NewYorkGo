package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tarek on 4/27/2018.
 */

public class Beaches {

    @SerializedName("Prop_ID")
    private String propID;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Surf")
    private String surf;

    @SerializedName("Note")
    private String note;

    @SerializedName("Accessible")
    private String accessible;

    @SerializedName("Accessible_Notes")
    private String accessibleNotes;

    @SerializedName("Barbecue_Allowed")
    private String barbecueAllowed;

    @SerializedName("Bathroom")
    private String bathroom;

    @SerializedName("Bicycle_and_Skate_Path")
    private String bicycleAndSkatePath;

    @SerializedName("Boardwalk")
    private String boardwalk;

    @SerializedName("Concession_Stand")
    private String concessionStand;

    @SerializedName("Performance_Pavilion")
    private String performancePavilion;

    @SerializedName("Mobile_Charging_Stations")
    private String MobileChargingStations;

    @SerializedName("Directions")
    private String directions;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lon")
    private String lon;

    @SerializedName("Description")
    private String description;

    public Beaches(String propID, String name, String location, String phone, String surf, String note, String accessible, String accessibleNotes, String barbecueAllowed, String bathroom, String bicycleAndSkatePath, String boardwalk, String concessionStand, String performancePavilion, String mobileChargingStations, String directions, String lat, String lon, String description) {
        this.propID = propID;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.surf = surf;
        this.note = note;
        this.accessible = accessible;
        this.accessibleNotes = accessibleNotes;
        this.barbecueAllowed = barbecueAllowed;
        this.bathroom = bathroom;
        this.bicycleAndSkatePath = bicycleAndSkatePath;
        this.boardwalk = boardwalk;
        this.concessionStand = concessionStand;
        this.performancePavilion = performancePavilion;
        MobileChargingStations = mobileChargingStations;
        this.directions = directions;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
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

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurf() {
        return surf;
    }

    public void setSurf(String surf) {
        this.surf = surf;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }

    public String getAccessibleNotes() {
        return accessibleNotes;
    }

    public void setAccessibleNotes(String accessibleNotes) {
        this.accessibleNotes = accessibleNotes;
    }

    public String getBarbecueAllowed() {
        return barbecueAllowed;
    }

    public void setBarbecueAllowed(String barbecueAllowed) {
        this.barbecueAllowed = barbecueAllowed;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getBicycleAndSkatePath() {
        return bicycleAndSkatePath;
    }

    public void setBicycleAndSkatePath(String bicycleAndSkatePath) {
        this.bicycleAndSkatePath = bicycleAndSkatePath;
    }

    public String getBoardwalk() {
        return boardwalk;
    }

    public void setBoardwalk(String boardwalk) {
        this.boardwalk = boardwalk;
    }

    public String getConcessionStand() {
        return concessionStand;
    }

    public void setConcessionStand(String concessionStand) {
        this.concessionStand = concessionStand;
    }

    public String getPerformancePavilion() {
        return performancePavilion;
    }

    public void setPerformancePavilion(String performancePavilion) {
        this.performancePavilion = performancePavilion;
    }

    public String getMobileChargingStations() {
        return MobileChargingStations;
    }

    public void setMobileChargingStations(String mobileChargingStations) {
        MobileChargingStations = mobileChargingStations;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
