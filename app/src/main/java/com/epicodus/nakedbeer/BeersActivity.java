package com.epicodus.nakedbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BeersActivity extends AppCompatActivity {
    public static final String TAG = BeersActivity.class.getSimpleName();

    @Bind(R.id.beersList)ListView mListOfBeers;
    //private String[] beers = new String[] {"American-style pale lager produced by Belgian multinational corporation Anheuser–Busch InBev.", "Calories: 12", "Alcohol % : 4.1", "Cholesterol: 0 mg", "Sodium: 14 mg", "Potassium: 96 mg", "Total Carbohydrate: 13 g", "Protein 1.6 g"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);



        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, beers);
       // mListOfBeers.setAdapter(adapter);

        Intent intent = getIntent();
        String styles = intent.getStringExtra("userInput");


        getBeerStyles(styles);
    }

    private void getBeerStyles(String styles) {
        final BeerService beerService = new BeerService();
        beerService.findBeerStyles(styles, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
