package com.softserve.academy.mosquito.fragments;

import android.app.Fragment;
import android.content.Intent;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.activity.TaskActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment {

    @Click()
    public void registrationButtonClicked() {
        getFragmentManager().beginTransaction().replace(R.id.fragments_container,
                new RegistrationFragment_(), "Registration fragment").addToBackStack("Registration fragment").commit();
    }

    @Click
    public void loginButtonClicked() {
        Intent intent = new Intent(getActivity(), TaskActivity_.class);
        startActivity(intent);
    }
}
