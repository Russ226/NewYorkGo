package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by russ on 4/27/18.
 */

public class IndoorSwimmingPool extends Recreation{
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
    private String lat;

    @SerializedName("long")
    private String longitude;

    @SerializedName("rec_center_id")
    private String recCenterId;

    private Double distance;

    public IndoorSwimmingPool(String propId, String name, String location, String phone, String poolsIndoorType, String setting, String size, String accessible, String lat, String longitude, String recCenterId) {
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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRecCenterId() {
        return recCenterId;
    }

    public void setRecCenterId(String recCenterId) {
        this.recCenterId = recCenterId;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public static Comparator<IndoorSwimmingPool> COMPARE_BY_DISTANCE = new Comparator<IndoorSwimmingPool>() {
        public int compare(IndoorSwimmingPool one, IndoorSwimmingPool other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
