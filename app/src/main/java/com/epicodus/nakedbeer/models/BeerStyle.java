package com.epicodus.nakedbeer.models;

import org.parceler.Parcel;

@Parcel
public class BeerStyle {
    private String Name;
    private String Description;
    private String ABV;
    private String SRM;
    private String IBU;

    public BeerStyle() {}

    public BeerStyle(String styleName, String description) {
        this.Name = styleName;
        this.Description = description;
//        this.ABV = ABV;
//        this.SRM = SRM;
//        this.IBU = IBU;
    }

    public String getStyleName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

//    public String getABV() {
//        return ABV;
//    }
//
//    public String getSRM() {
//        return ABV;
//    }
//
//    public String getIBU() {
//        return ABV;
//    }

}
