package com.epicodus.nakedbeer.ui;

import android.os.Parcel;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.adapters.BeerStylePagerAdapter;
import com.epicodus.nakedbeer.models.BeerStyle;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeerStyleDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private BeerStylePagerAdapter adapterViewPager;
    ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_style_detail);
        ButterKnife.bind(this);

        mBeerStyles = Parcels.unwrap(getIntent().getParcelableExtra("beerStyles"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new BeerStylePagerAdapter(getSupportFragmentManager(), mBeerStyles);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
