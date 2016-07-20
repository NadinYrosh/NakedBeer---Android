package com.epicodus.nakedbeer.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.nakedbeer.Constants;
import com.epicodus.nakedbeer.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Bind(R.id.BeerInput) EditText mBeerInput;
    @Bind(R.id.bFind)Button mFindBeerStyle;
    @Bind(R.id.tLogo)TextView mLogo;
    @Bind(R.id.bSaved)Button mSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindBeerStyle.setOnClickListener(this);
        mSaved.setOnClickListener(this);

        Typeface FFF_Tusj = Typeface.createFromAsset(getAssets(), "fonts/FFF_Tusj.ttf");
        mLogo.setTypeface(FFF_Tusj);

    }

    @Override
    public void onClick(View view) {
        if (view == mFindBeerStyle) {
            String userInput = mBeerInput.getText().toString();
            if(!(userInput).equals("")) {
                addToSharedPreferences(userInput);
            }
            Intent intent = new Intent(HomeActivity.this, BeersStyleListActivity.class);
//            intent.putExtra("userInput", userInput);
            startActivity(intent);
        }
        if(view == mSaved) {
            Intent intent = new Intent(HomeActivity.this, SavedBeerStyeListActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void addToSharedPreferences(String userInput) {
        mEditor.putString(Constants.PREFERENCES_BEERSTYLE_KEY, userInput).apply();
    }
}
