package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by russ on 4/27/18.
 */

public class IceSkating extends Recreation{
    @SerializedName("Prop_ID")
    private String propId;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Accessible")
    private String accessible;

    @SerializedName("IceSkating_Type")
    private String type;

    @SerializedName("Public_Skate_Admission_Price_Adult")
    private String publicSkateAdmissionPriceAdult;

    @SerializedName("Public_Skate_Admission_Price_Child")
    private String publicSkateAdmissionPriceChild;

    @SerializedName("Public_Skate_Admission_Price_Senior")
    private String publicSkateAdmissionPriceSenior;

    @SerializedName("Opening_Date")
    private String openingDate;

    @SerializedName("Closing_Date")
    private String closingDate;

    @SerializedName("Sunday_Public_Skating_Hours")
    private String sundayPublicSkatingHours;

    @SerializedName("Monday_Public_Skating_Hours")
    private String mondayPublicSkatingHours;

    @SerializedName("Tuesday_Public_Skating_Hours")
    private String tuesdayPublicSkatingHours;

    @SerializedName("Wednesday_Public_Skating_Hours")
    private String wednesdayPublicSkatingHours;

    @SerializedName("Thursday_Public_Skating_Hours")
    private String thursdayPublicSkatingHours;

    @SerializedName("Friday_Public_Skating_Hours")
    private String fridayPublicSkatingHours;

    @SerializedName("Saturday_Public_Skating_Hours")
    private String saturdayPublicSkatingHours;

    @SerializedName("Holiday_Public_Skating_Hours")
    private String holidayPublicSkatingHours;

    @SerializedName("Programming")
    private String programming;

    @SerializedName("Notes")
    private String notes;

    private Double distance;

    public IceSkating(String propId, String name, String location, String phone, String accessible, String type, String publicSkateAdmissionPriceAdult, String publicSkateAdmissionPriceChild, String publicSkateAdmissionPriceSenior, String openingDate, String closingDate, String sundayPublicSkatingHours, String mondayPublicSkatingHours, String tuesdayPublicSkatingHours, String wednesdayPublicSkatingHours, String thursdayPublicSkatingHours, String fridayPublicSkatingHours, String saturdayPublicSkatingHours, String holidayPublicSkatingHours, String programming, String notes) {
        this.propId = propId;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.accessible = accessible;
        this.type = type;
        this.publicSkateAdmissionPriceAdult = publicSkateAdmissionPriceAdult;
        this.publicSkateAdmissionPriceChild = publicSkateAdmissionPriceChild;
        this.publicSkateAdmissionPriceSenior = publicSkateAdmissionPriceSenior;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.sundayPublicSkatingHours = sundayPublicSkatingHours;
        this.mondayPublicSkatingHours = mondayPublicSkatingHours;
        this.tuesdayPublicSkatingHours = tuesdayPublicSkatingHours;
        this.wednesdayPublicSkatingHours = wednesdayPublicSkatingHours;
        this.thursdayPublicSkatingHours = thursdayPublicSkatingHours;
        this.fridayPublicSkatingHours = fridayPublicSkatingHours;
        this.saturdayPublicSkatingHours = saturdayPublicSkatingHours;
        this.holidayPublicSkatingHours = holidayPublicSkatingHours;
        this.programming = programming;
        this.notes = notes;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicSkateAdmissionPriceAdult() {
        return publicSkateAdmissionPriceAdult;
    }

    public void setPublicSkateAdmissionPriceAdult(String publicSkateAdmissionPriceAdult) {
        this.publicSkateAdmissionPriceAdult = publicSkateAdmissionPriceAdult;
    }

    public String getPublicSkateAdmissionPriceChild() {
        return publicSkateAdmissionPriceChild;
    }

    public void setPublicSkateAdmissionPriceChild(String publicSkateAdmissionPriceChild) {
        this.publicSkateAdmissionPriceChild = publicSkateAdmissionPriceChild;
    }

    public String getPublicSkateAdmissionPriceSenior() {
        return publicSkateAdmissionPriceSenior;
    }

    public void setPublicSkateAdmissionPriceSenior(String publicSkateAdmissionPriceSenior) {
        this.publicSkateAdmissionPriceSenior = publicSkateAdmissionPriceSenior;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getSundayPublicSkatingHours() {
        return sundayPublicSkatingHours;
    }

    public void setSundayPublicSkatingHours(String sundayPublicSkatingHours) {
        this.sundayPublicSkatingHours = sundayPublicSkatingHours;
    }

    public String getMondayPublicSkatingHours() {
        return mondayPublicSkatingHours;
    }

    public void setMondayPublicSkatingHours(String mondayPublicSkatingHours) {
        this.mondayPublicSkatingHours = mondayPublicSkatingHours;
    }

    public String getTuesdayPublicSkatingHours() {
        return tuesdayPublicSkatingHours;
    }

    public void setTuesdayPublicSkatingHours(String tuesdayPublicSkatingHours) {
        this.tuesdayPublicSkatingHours = tuesdayPublicSkatingHours;
    }

    public String getWednesdayPublicSkatingHours() {
        return wednesdayPublicSkatingHours;
    }

    public void setWednesdayPublicSkatingHours(String wednesdayPublicSkatingHours) {
        this.wednesdayPublicSkatingHours = wednesdayPublicSkatingHours;
    }

    public String getThursdayPublicSkatingHours() {
        return thursdayPublicSkatingHours;
    }

    public void setThursdayPublicSkatingHours(String thursdayPublicSkatingHours) {
        this.thursdayPublicSkatingHours = thursdayPublicSkatingHours;
    }

    public String getFridayPublicSkatingHours() {
        return fridayPublicSkatingHours;
    }

    public void setFridayPublicSkatingHours(String fridayPublicSkatingHours) {
        this.fridayPublicSkatingHours = fridayPublicSkatingHours;
    }

    public String getSaturdayPublicSkatingHours() {
        return saturdayPublicSkatingHours;
    }

    public void setSaturdayPublicSkatingHours(String saturdayPublicSkatingHours) {
        this.saturdayPublicSkatingHours = saturdayPublicSkatingHours;
    }

    public String getHolidayPublicSkatingHours() {
        return holidayPublicSkatingHours;
    }

    public void setHolidayPublicSkatingHours(String holidayPublicSkatingHours) {
        this.holidayPublicSkatingHours = holidayPublicSkatingHours;
    }

    public String getProgramming() {
        return programming;
    }

    public void setProgramming(String programming) {
        this.programming = programming;
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

    public static Comparator<IceSkating> COMPARE_BY_DISTANCE = new Comparator<IceSkating>() {
        public int compare(IceSkating one, IceSkating other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
