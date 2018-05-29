package com.softserve.academy.mosquito.activity;

import android.app.Activity;
import android.os.Bundle;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.fragments.LoginFragment_;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().add(R.id.fragments_container,
                 new LoginFragment_(), "Login fragment").commit();
    }
}