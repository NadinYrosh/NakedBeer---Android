package com.epicodus.nakedbeer;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class BeerService {
    public static final String TAG = BeerService.class.getSimpleName();

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

    public ArrayList<BeerStyle> processResults(Response response) {
        ArrayList<BeerStyle> beerStyles = new ArrayList<>();

        try{
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject bdbJSON = new JSONObject(jsonData);
                JSONArray dataJSON = bdbJSON.getJSONArray("data");
                for (int i = 0; i < dataJSON.length(); i++){

                    JSONObject styleJSON = dataJSON.getJSONObject(i);

                    String styleName = styleJSON.getString("name"); //not getting the mane...returns object.

                    BeerStyle beer = new BeerStyle(styleName);
                    beerStyles.add(beer);

                    Log.v(TAG, styleName);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beerStyles;
    }
}
