package com.epicodus.nakedbeer.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.nakedbeer.Constants;
import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeerStyleDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.styleNameTextView) TextView mStyleName;
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
        mSaveButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
       //for  Implicit intents...
        if (view == mSaveButton) {
            DatabaseReference beerStyleRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BEER_STYLES);
            beerStyleRef.push().setValue(mBeerStyle);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
