package com.epicodus.nakedbeer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.bRegister)Button mRegister;
    @Bind(R.id.etName) EditText mName;
    @Bind(R.id.etUsername) EditText mUserName;
    @Bind(R.id.etPassword) EditText mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

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
