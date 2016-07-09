package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.nakedbeer.R;


import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.bLogin)Button mLogin;
    @Bind(R.id.etUsername) EditText mUsername;
    @Bind(R.id.etPassword) EditText mPassword;
    @Bind(R.id.tvRegisterLink) TextView mRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLogin.setOnClickListener(this);
        mRegisterLink.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);


        switch (view.getId()){
            case R.id.bLogin:

                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}