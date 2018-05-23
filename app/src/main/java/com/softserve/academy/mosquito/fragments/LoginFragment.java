package com.softserve.academy.mosquito.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softserve.academy.mosquito.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.jetbrains.annotations.Nullable;

@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);

        return view;
    }


    @Click()
    public void registrationButtonClicked(){
        getFragmentManager().beginTransaction().replace(R.id.fragments_container,
                new RegistrationFragment_(), "Registration fragment").commit();
    }

}
