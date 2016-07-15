package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.nakedbeer.Constants;
import com.epicodus.nakedbeer.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Bind(R.id.BeerInput) EditText mBeerInput;
    @Bind(R.id.bFind)Button mFindBeerStyle;
    @Bind(R.id.tLogo)TextView mLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindBeerStyle.setOnClickListener(this);

        Typeface FFF_Tusj = Typeface.createFromAsset(getAssets(), "fonts/FFF_Tusj.ttf");
        mLogo.setTypeface(FFF_Tusj);

    }

    @Override
    public void onClick(View view) {
        if (view == mFindBeerStyle) {
            String userInput = mBeerInput.getText().toString();
            addToSharedPreferences(userInput);
            Intent intent = new Intent(HomeActivity.this, BeersStyleListActivity.class);
            intent.putExtra("userInput", userInput);
            startActivity(intent);
        }

    }

    private void addToSharedPreferences(String userInput) {
        mEditor.putString(Constants.PREFERENCES_BEERSTYLE_KEY, userInput).apply();
    }
}
