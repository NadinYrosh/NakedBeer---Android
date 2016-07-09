package com.epicodus.nakedbeer.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.bRegister)Button mRegister;
    @Bind(R.id.etName) EditText mName;
    @Bind(R.id.etUsername) EditText mUserName;
    @Bind(R.id.etPassword) EditText mPassword;
    @Bind(R.id.logoText)TextView mLogoText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

       Typeface FFF_Tusj = Typeface.createFromAsset(getAssets(), "fonts/FFF_Tusj.ttf");
        mLogoText.setTypeface(FFF_Tusj);

        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bRegister:
                break;
        }
    }
}
