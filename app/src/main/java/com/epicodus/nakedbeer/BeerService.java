package com.epicodus.nakedbeer;
import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class BeerService {
    public static final String TAG = BeersActivity.class.getSimpleName();

    public static void findBeerStyles(String userInput, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder().build();

        String url = Constants.Base_URL + "style?q=" + userInput + "&withDescriptions=y" + "&key=" + Constants.Key;

        Log.v(TAG, url);


        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


}
