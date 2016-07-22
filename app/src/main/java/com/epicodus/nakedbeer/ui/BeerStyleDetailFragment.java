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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeerStyleDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.styleNameTextView) TextView mStyleName;
    @Bind(R.id.saveButton) TextView mSaveButton;
    @Bind(R.id. descriptionTextView) TextView mDescription;
    @Bind(R.id.abvTextView) TextView mABV;
    @Bind(R.id.srmTextView) TextView mSRM;
    @Bind(R.id.ibuTextView) TextView mIBU;
    @Bind(R.id.infoTextView) TextView mInfoIcon;


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

        mInfoIcon.setOnClickListener(this);

        mStyleName.setText(mBeerStyle.getStyleName());
        mDescription.setText(mBeerStyle.getDescription());
        mABV.setText("ABV: " + Double.toString(mBeerStyle.getABV()) + " %");
        mSRM.setText("SRM: " + Double.toString(mBeerStyle.getSRM()));
        mIBU.setText("IBU: " + Double.toString(mBeerStyle.getIBU()));
        //call other params from API


        mSaveButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
       if (view == mInfoIcon){
       Intent webInfoIntent = new Intent(Intent.ACTION_VIEW,
               Uri.parse("http://www.brewerydb.com/about/beer101"));
           startActivity(webInfoIntent);
       }
        if (view == mSaveButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            DatabaseReference beerStyleRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_BEER_STYLES)
                    .child(uid);;

            DatabaseReference pushRef = beerStyleRef.push();
            String pushId = pushRef.getKey();
            mBeerStyle.setPushId(pushId);
            pushRef.setValue(mBeerStyle);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}


//                        mCategoriesLabel.setText(android.text.TextUtils.join(", ", mRestaurant.getCategories()));
//                        mRatingLabel.setText(Double.toString(mRestaurant.getRating()) + "/5");