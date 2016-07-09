package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.epicodus.nakedbeer.services.BeerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BeersActivity extends AppCompatActivity {
    public static final String TAG = BeersActivity.class.getSimpleName();

    @Bind(R.id.bStylesList)ListView mStylesList;

    public ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);

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
                mBeerStyles = beerService.processResults(response);

                BeersActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] styleNames = new String[mBeerStyles.size()];
                        for (int i = 0; i < styleNames.length; i++) {
                            styleNames[i] = mBeerStyles.get(i).getStyleName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(BeersActivity.this,
                                android.R.layout.simple_list_item_1, styleNames);
                        mStylesList.setAdapter(adapter);

                        for (BeerStyle beerStyle : mBeerStyles) {
                            Log.v(TAG, "Name" + beerStyle.getStyleName());
                        }
                    }
                });
//                try {
//                    String jsonData = response.body().string();
//                    if (response.isSuccessful()) {
//                        Log.v(TAG, jsonData);
//
//                    }
//                    Log.v(TAG, jsonData);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }
}
