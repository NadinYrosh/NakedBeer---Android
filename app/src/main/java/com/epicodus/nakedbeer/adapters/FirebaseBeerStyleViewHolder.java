package com.epicodus.nakedbeer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.nakedbeer.Constants;
import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.epicodus.nakedbeer.ui.BeerStyleDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseBeerStyleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;

    public FirebaseBeerStyleViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }


    public void bindStyle(BeerStyle beerStyle) {
        TextView beerStyleNameTextView = (TextView) mView.findViewById(R.id.styleNameTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.descriptionTextView);

        beerStyleNameTextView.setText(beerStyle.getStyleName());
        descriptionTextView.setText(beerStyle.getDescription());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<BeerStyle> beerStyles = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BEER_STYLES);
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
