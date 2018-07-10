package com.softserve.academy.mosquito.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.fragments.LoginFragment_;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("Credentials", Context.MODE_PRIVATE);
        String token = preferences.getString("Authorization", null);

        if (token != null) {
            Intent intent = new Intent(this, TaskActivity_.class);
            startActivity(intent);
        } else
            getSupportFragmentManager().beginTransaction().add(R.id.fragments_container,
                    new LoginFragment_(), "Login fragment").commit();
    }
}