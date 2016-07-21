package com.epicodus.nakedbeer;


public class Constants {
    public static final String Key = BuildConfig.Key;
    public static final String Base_URL = "http://api.brewerydb.com/v2/search/";
    public static final String FIREBASE_CHILD_SEARCH_BEER_STYLE = "searchBeerStyle";
    public static final String FIREBASE_CHILD_BEER_STYLES = "beerStyles";
    public static final String PREFERENCES_BEERSTYLE_KEY = "beerstyle";
    public static final String KEY_SOURCE = "source"; //represent the key in the key-value pair of the intent extra.
    public static final String SOURCE_SAVED = "saved"; //corresponding value when the user navigates to this fragment through the SavedRestaurantListActivity
    public static final String SOURCE_FIND = "find"; //represent the value when the user travels from the BeerStyleListActivity
}
