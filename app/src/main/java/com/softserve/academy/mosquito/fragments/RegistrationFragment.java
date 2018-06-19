package com.softserve.academy.mosquito.fragments;

import android.app.Fragment;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.model.User;
import com.softserve.academy.mosquito.network.configuration.RetrofitConfiguration;
import com.softserve.academy.mosquito.network.service.UserService;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EFragment(R.layout.fragment_registration)
public class RegistrationFragment extends Fragment {

    @ViewById(R.id.email_registration)
    EditText email;

    @ViewById(R.id.first_name)
    EditText firstName;

    @ViewById(R.id.last_name)
    EditText lastName;

    @ViewById(R.id.password)
    EditText password;

    @ViewById(R.id.confirm_password)
    EditText confirmPassword;

    @Click
    public void confirmButtonClicked() {
        User userForRegister = new User(
                email.getText().toString(),
                firstName.getText().toString(),
                lastName.getText().toString(),
                password.getText().toString(),
                confirmPassword.getText().toString());

        Log.d("User ", userForRegister.toString());

        UserService userService = RetrofitConfiguration.getRetrofit().create(UserService.class);
        Call<User> registration = userService.registration(userForRegister);

        registration.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getActivity(), "Status " + response.code(), Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragments_container, new LoginFragment_()).commit();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
