package com.tareksaidee.newyorkgo.DTO;

public class Zoo {
    private int prop_id;
    private String name;
    private String location;
    private String phone_num;

    public int getProp_id() {
        return prop_id;
    }

    public Zoo(int prop_id, String name, String location, String phone_num) {
        this.prop_id = prop_id;
        this.name = name;
        this.location = location;
        this.phone_num = phone_num;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setProp_id(int prop_id) {
        this.prop_id = prop_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}

