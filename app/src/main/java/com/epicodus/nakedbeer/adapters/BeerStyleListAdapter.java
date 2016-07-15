package com.epicodus.nakedbeer.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;
import com.epicodus.nakedbeer.ui.BeerStyleDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeerStyleListAdapter extends RecyclerView.Adapter<BeerStyleListAdapter.StyleViewHolder> {
    private ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();
    private Context mContext;

    public BeerStyleListAdapter(Context context, ArrayList<BeerStyle> beerStyles) {
        mContext = context;
        mBeerStyles = beerStyles;
    }

    @Override
    public BeerStyleListAdapter.StyleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_style_list_item, parent, false);

        StyleViewHolder viewHolder = new StyleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BeerStyleListAdapter.StyleViewHolder holder, int position) {
    holder.bindStyle(mBeerStyles.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeerStyles.size();
    }

    public class StyleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       @Bind(R.id.styleImageView) ImageView mStyleImageView;
       @Bind(R.id.styleNameTextView) TextView mStyleNameTextView;
       @Bind(R.id.descriptionTextView) TextView mDescriptionNameTextView;

        private Context mContext;

        public StyleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindStyle(BeerStyle beerStyle) {
            mStyleNameTextView.setText(beerStyle.getStyleName());
            mDescriptionNameTextView.setText(beerStyle.getDescription());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, BeerStyleDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("beerStyles", Parcels.wrap(mBeerStyles));
            mContext.startActivity(intent);
        }
    }
}
