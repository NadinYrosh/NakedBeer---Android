package com.epicodus.nakedbeer.models;

import org.parceler.Parcel;

@Parcel
public class BeerStyle {
    private String styleName;
    private String description;
    private String mABV;
    private String mSRM;
    private String mIBU;

    public BeerStyle() {}

    public BeerStyle(String styleName, String description) {
        this.styleName = styleName;
        this.description = description;
//        this.mABV = ABV;
//        this.mSRM = SRM;
//        this.mIBU = IBU;
    }

    public String getStyleName() {
        return styleName;
    }

    public String getDescription() {
        return description;
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
