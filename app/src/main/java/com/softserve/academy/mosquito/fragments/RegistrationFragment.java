package com.softserve.academy.mosquito.fragments;

import android.app.Fragment;
import android.widget.Toast;

import com.softserve.academy.mosquito.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_registration)
public class RegistrationFragment extends Fragment {

    @Click
    public void confirmButtonClicked() {
        Toast.makeText(getActivity(), "Clicked!", Toast.LENGTH_SHORT).show();
    }
}
