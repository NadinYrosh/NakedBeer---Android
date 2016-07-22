package com.epicodus.nakedbeer.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.nakedbeer.Constants;
import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.epicodus.nakedbeer.ui.BeerStyleDetailActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FirebaseBeerStyleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;
    @Bind(R.id.styleImageView)
    ImageView mStyleImageView;


    public FirebaseBeerStyleViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }


    public void bindStyle(BeerStyle beerStyle) {
        TextView beerStyleNameTextView = (TextView) mView.findViewById(R.id.styleNameTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.descriptionTextView);

        beerStyleNameTextView.setText(beerStyle.getStyleName());
        descriptionTextView.setText(beerStyle.getDescription());

        //random image generator for saved list
        TypedArray imgs = mContext.getResources().obtainTypedArray(R.array.random_images_array);
        Random random = new Random();
        int rndInt = random.nextInt(imgs.length());
        int resID = imgs.getResourceId(rndInt, 0);
        mStyleImageView.setImageResource(resID);

    }

    @Override
    public void onClick(View view) {
        final ArrayList<BeerStyle> beerStyles = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BEER_STYLES).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    beerStyles.add(snapshot.getValue(BeerStyle.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, BeerStyleDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("beerStyles", Parcels.wrap(beerStyles));

                mContext.startActivity(intent);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
