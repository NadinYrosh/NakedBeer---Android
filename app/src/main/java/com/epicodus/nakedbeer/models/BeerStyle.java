package com.epicodus.nakedbeer.models;

import org.parceler.Parcel;

@Parcel
public class BeerStyle {
    private String mName;
    private String mDescription;
    private String mABV;
    private String mSRM;
    private String mIBU;

    public BeerStyle() {}

    public BeerStyle(String styleName, String description) {
        this.mName = styleName;
        this.mDescription = description;
//        this.mABV = ABV;
//        this.mSRM = SRM;
//        this.mIBU = IBU;
    }

    public String getStyleName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getABV() {
        return mABV;
    }

    public String getSRM() {
        return mABV;
    }

    public String getIBU() {
        return mABV;
    }

}
