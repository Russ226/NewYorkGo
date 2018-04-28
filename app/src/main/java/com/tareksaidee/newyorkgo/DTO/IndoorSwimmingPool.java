package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 4/27/18.
 */

public class IndoorSwimmingPool {
    @SerializedName("Prop_ID")
    private String propId;

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Pools_indoor_Type")
    private String poolsIndoorType;

    @SerializedName("Setting")
    private String setting;

    @SerializedName("Size")
    private String size;

    @SerializedName("Accessible")
    private String accessible;

    @SerializedName("lat")
    private double lat;

    @SerializedName("long")
    private double longitude;

    @SerializedName("rec_center_id")
    private String recCenterId;

    public IndoorSwimmingPool(String propId, String name, String location, String phone, String poolsIndoorType, String setting, String size, String accessible, double lat, double longitude, String recCenterId) {
        this.propId = propId;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.poolsIndoorType = poolsIndoorType;
        this.setting = setting;
        this.size = size;
        this.accessible = accessible;
        this.lat = lat;
        this.longitude = longitude;
        this.recCenterId = recCenterId;
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

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPoolsIndoorType() {
        return poolsIndoorType;
    }

    public void setPoolsIndoorType(String poolsIndoorType) {
        this.poolsIndoorType = poolsIndoorType;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getRecCenterId() {
        return recCenterId;
    }

    public void setRecCenterId(String recCenterId) {
        this.recCenterId = recCenterId;
    }
}
