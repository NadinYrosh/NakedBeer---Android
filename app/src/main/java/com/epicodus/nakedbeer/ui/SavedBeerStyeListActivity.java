package com.epicodus.nakedbeer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.nakedbeer.Constants;
import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.adapters.FirebaseBeerStyleViewHolder;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedBeerStyeListActivity extends AppCompatActivity {
    private DatabaseReference mBeerStyleReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);

        mBeerStyleReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BEER_STYLES);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<BeerStyle, FirebaseBeerStyleViewHolder>
                (BeerStyle.class, R.layout.beer_style_list_item, FirebaseBeerStyleViewHolder.class, mBeerStyleReference) {

            @Override
            protected void populateViewHolder(FirebaseBeerStyleViewHolder viewHolder,
                                              BeerStyle model, int position) {
                viewHolder.bindStyle(model);
            }
        };

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
