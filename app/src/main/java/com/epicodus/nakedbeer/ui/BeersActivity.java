package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.adapters.StyleListAdapter;
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

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private StyleListAdapter mAdapter;

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
            public void onResponse(Call call, Response response) {
                mBeerStyles = beerService.processResults(response);

                BeersActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new StyleListAdapter(getApplicationContext(), mBeerStyles);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BeersActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);




                        String[] styleNames = new String[mBeerStyles.size()];
                        for (int i = 0; i < styleNames.length; i++) {
                            styleNames[i] = mBeerStyles.get(i).getStyleName();
                        }


                        for (BeerStyle beerStyle : mBeerStyles) {
                            Log.v(TAG, "Name" + beerStyle.getStyleName());
                        }
                    }
                });
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v(TAG, jsonData);

                    }
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
