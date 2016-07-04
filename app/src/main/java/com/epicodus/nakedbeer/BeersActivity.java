package com.epicodus.nakedbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeersActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.BeersTextView)TextView mBeers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String beer = intent.getStringExtra("beer");
        mBeers.setText("Here is some information about: " + beer);
    }

    @Override
    public void onClick(View view) {

    }
}
