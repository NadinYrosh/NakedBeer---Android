package com.epicodus.nakedbeer.models;

import org.parceler.Parcel;

@Parcel
public class BeerStyle {
    private String Name;
    private String Description;
    private String mABV;
    private String mSRM;
    private String mIBU;

    public BeerStyle() {}

    public BeerStyle(String styleName, String description) {
        this.Name = styleName;
        this.Description = description;
//        this.mABV = ABV;
//        this.mSRM = SRM;
//        this.mIBU = IBU;
    }

    public String getStyleName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

//    public String getABV() {
//        return mABV;
//    }
//
//    public String getSRM() {
//        return mABV;
//    }
//
//    public String getIBU() {
//        return mABV;
//    }

}
