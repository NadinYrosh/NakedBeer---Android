package com.epicodus.nakedbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeersActivity extends AppCompatActivity {
    @Bind(R.id.BeersTextView)TextView mBeers;
    @Bind(R.id.beersList)ListView mListOfBeers;
    private String[] beers = new String[] {"American-style pale lager produced by Belgian multinational corporation Anheuser–Busch InBev.", "Calories: 12", "Alcohol % : 4.1", "Cholesterol: 0 mg", "Sodium: 14 mg", "Potassium: 96 mg", "Total Carbohydrate: 13 g", "Protein 1.6 g"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String beer = intent.getStringExtra("beer");
        //mBeers.setText("Here is some information about: " + beer);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, beers);
        mListOfBeers.setAdapter(adapter);

    }
}
