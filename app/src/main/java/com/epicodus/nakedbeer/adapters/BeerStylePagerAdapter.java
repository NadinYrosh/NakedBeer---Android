package com.epicodus.nakedbeer.adapters;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.epicodus.nakedbeer.ui.BeerStyleDetailFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BeerStylePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<BeerStyle> mBeerStyles;

    public BeerStylePagerAdapter(FragmentManager fm, ArrayList<BeerStyle> beerStyles) {
        super(fm);
        mBeerStyles = beerStyles;
    }


    @Override
    public Fragment getItem(int position) {
        return BeerStyleDetailFragment.newInstance(mBeerStyles.get(position));
    }

    @Override
    public int getCount() {
        return mBeerStyles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBeerStyles.get(position).getStyleName();
    }

}
