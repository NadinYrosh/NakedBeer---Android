package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.BeerInput) EditText mBeerInput;
    @Bind(R.id.bFind)Button mFindBeer;
    @Bind(R.id.tLogo)TextView mLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mFindBeer.setOnClickListener(this);

        Typeface FFF_Tusj = Typeface.createFromAsset(getAssets(), "fonts/FFF_Tusj.ttf");
        mLogo.setTypeface(FFF_Tusj);

    }

    @Override
    public void onClick(View view) {
        String userInput = mBeerInput.getText().toString();
        Intent intent = new Intent(HomeActivity.this, BeersStyleListActivity.class);
        intent.putExtra("userInput", userInput);
        startActivity(intent);
        //switch (view.getId()){
            //case R.id.bRegister:
                //break;
        //}
    }
}
