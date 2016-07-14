package com.epicodus.nakedbeer.models;

import org.parceler.Parcel;

@Parcel
public class BeerStyle {
    private String mName;
    private String mDescription;

    public BeerStyle() {}

    public BeerStyle(String styleName, String description) {
        this.mName = styleName;
        this.mDescription = description;
    }

    public String getStyleName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

}
