package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.nakedbeer.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LogoutActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.bLogout)Button mLogout;
    @Bind(R.id.etName) EditText mName;
    @Bind(R.id.etUsername) EditText mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bLogout:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
