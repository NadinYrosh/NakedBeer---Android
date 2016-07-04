package com.epicodus.nakedbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.BeerInput) EditText mBeerInput;
    @Bind(R.id.bFind)Button mFindBeer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mFindBeer.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String beer = mBeerInput.getText().toString();
        Intent intent = new Intent(HomeActivity.this, BeersActivity.class);
        intent.putExtra("beer",beer);
        startActivity(intent);
        //switch (view.getId()){
            //case R.id.bRegister:
                //break;
        //}
    }
}
