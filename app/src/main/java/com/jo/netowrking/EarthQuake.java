package com.jo.netowrking;

import java.util.Date;

/**
 * Created by ahmed on 27/11/2017.
 */

public class EarthQuake {
    private double power;
    private String location;
    private String country;
    private Date date;
    private String url;

    public EarthQuake(double power, String location, String country, Date date, String url) {
        this.power = power;
        this.location = location;
        this.country = country;
        this.date = date;
        this.url = url;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
