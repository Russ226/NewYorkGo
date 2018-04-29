package com.tareksaidee.newyorkgo.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by russ on 4/27/18.
 */

public class OutdoorSwimming extends Recreation{
    @SerializedName("Prop_ID")
    private String propID;

    @SerializedName("Name")
    private String name;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Pools_outdoor_Type")
    private String poolsOutdoorType;

    @SerializedName("Setting")
    private String setting;

    @SerializedName("Size")
    private String size;

    @SerializedName("lat")
    private String lat;

    @SerializedName("long")
    private String longitude;

    @SerializedName("rec_center_id")
    private String recCenterId;

    private Double distance;

    public OutdoorSwimming(String propID, String name, String phone, String poolsOutdoorType, String setting, String size, String lat, String longitude, String recCenterId) {
        this.propID = propID;
        this.name = name;
        this.phone = phone;
        this.poolsOutdoorType = poolsOutdoorType;
        this.setting = setting;
        this.size = size;
        this.lat = lat;
        this.longitude = longitude;
        this.recCenterId = recCenterId;
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

    @Override
    public String getLocation() {
        return null;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPoolsOutdoorType() {
        return poolsOutdoorType;
    }

    public void setPoolsOutdoorType(String poolsOutdoorType) {
        this.poolsOutdoorType = poolsOutdoorType;
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

    public static Comparator<OutdoorSwimming> COMPARE_BY_DISTANCE = new Comparator<OutdoorSwimming>() {
        public int compare(OutdoorSwimming one, OutdoorSwimming other) {
            return one.distance.compareTo(other.distance);
        }
    };
}
