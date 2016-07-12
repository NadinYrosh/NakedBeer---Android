package com.epicodus.nakedbeer.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;
import com.epicodus.nakedbeer.models.BeerStyle;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StyleListAdapter extends RecyclerView.Adapter<StyleListAdapter.StyleViewHolder> {
    private ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();
    private Context mContext;

    public StyleListAdapter(Context context, ArrayList<BeerStyle> beerStyles) {
        mContext = context;
        mBeerStyles = beerStyles;
    }

    @Override
    public StyleListAdapter.StyleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_style_list_item, parent, false);

        StyleViewHolder viewHolder = new StyleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StyleListAdapter.StyleViewHolder holder, int position) {
    holder.bindStyle(mBeerStyles.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeerStyles.size();
    }

    public class StyleViewHolder extends RecyclerView.ViewHolder {
       @Bind(R.id.styleImageView) ImageView mStyleImageView;
       @Bind(R.id.styleNameTextView) TextView mStyleNameTextView;
       @Bind(R.id.descriptionTextView) TextView mDescriptionNameTextView;

        private Context mContext;

        public StyleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindStyle(BeerStyle beerStyle) {
            mStyleNameTextView.setText(beerStyle.getStyleName());
            //mDescriptionNameTextView.setText(beerStyle.getDescription());
        }
    }
}
