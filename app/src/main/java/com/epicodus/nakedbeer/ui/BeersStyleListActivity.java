package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.epicodus.nakedbeer.Constants;
import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.adapters.BeerStyleListAdapter;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.epicodus.nakedbeer.services.BeerService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BeersStyleListActivity extends AppCompatActivity {
    public static final String TAG = BeersStyleListActivity.class.getSimpleName();
    private SharedPreferences mSharedPreferences;
    private String mRecentStyle;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private BeerStyleListAdapter mAdapter;
    public ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);

//        Intent intent = getIntent();
//        String styles = intent.getStringExtra("userInput");
//        getBeerStyles(styles);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentStyle = mSharedPreferences.getString(Constants.PREFERENCES_BEERSTYLE_KEY, null);
        if (mRecentStyle != null) {
            getBeerStyles(mRecentStyle);
        };
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
                if (mBeerStyles.size() == 0 ) {
                    Intent intent = new Intent(BeersStyleListActivity.this, BadEntryActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                }
                Log.v(TAG, Integer.toString(mBeerStyles.size()));

                BeersStyleListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new BeerStyleListAdapter(getApplicationContext(), mBeerStyles);

                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BeersStyleListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
//                Log.v(TAG, "LOG FOR THE BODY" + response.body().toString());
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

//    JSONObject responseJSON = new JSONObject(jsonData);
//! responseJSON.has("totalResults");

