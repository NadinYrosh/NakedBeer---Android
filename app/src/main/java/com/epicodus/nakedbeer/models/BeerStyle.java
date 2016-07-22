package com.epicodus.nakedbeer.models;

import org.parceler.Parcel;

@Parcel
public class BeerStyle {
    private String styleName;
    private String description;
    private double abv;
    private double srm;
    private double ibu;
    private String pushId;

    public BeerStyle() {}

    public BeerStyle(String styleName, String description, double abv, double srm, double ibu ) {
        this.styleName = styleName;
        this.description = description;
        this.abv = abv;
        this.srm = srm;
        this.ibu = ibu;
    }

    public String getStyleName() {
        return styleName;
    }

    public String getDescription() {
        return description;
    }

    public double getABV() {
        return abv;
    }

    public double getSRM() {
        return srm;
    }

    public double getIBU() {
        return ibu;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
