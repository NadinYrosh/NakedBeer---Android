package com.epicodus.nakedbeer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.bLogin)Button mbLogin;
    @Bind(R.id.etUsername) EditText mUsername;
    @Bind(R.id.etPassword) EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mbLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bLogin:
                break;
        }
    }
}