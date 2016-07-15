package com.epicodus.nakedbeer.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeerStyleDetailFragment extends Fragment {
    @Bind(R.id.styleNameTextView) TextView mStyleName;
    @Bind(R.id.sendTextView) TextView mSend;
    @Bind(R.id.saveButton) TextView mSaveButton;
    @Bind(R.id. descriptionTextView) TextView mDescription;

    private BeerStyle  mBeerStyle;

    public BeerStyleDetailFragment() {}

    public static BeerStyleDetailFragment newInstance(BeerStyle beerStyle) {
        BeerStyleDetailFragment styleFragment = new BeerStyleDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("beerStyle", Parcels.wrap(beerStyle));
        styleFragment.setArguments(args);
        return styleFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeerStyle = Parcels.unwrap(getArguments().getParcelable("beerStyle"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beer_style_fragment_detail_fragment, container, false);
        ButterKnife.bind(this, view);
        mStyleName.setText(mBeerStyle.getStyleName());
        mDescription.setText(mBeerStyle.getDescription());

        return view;
    }
}
