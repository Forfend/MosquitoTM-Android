package com.softserve.academy.mosquito.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.activity.TaskActivity_;
import com.softserve.academy.mosquito.model.User;
import com.softserve.academy.mosquito.network.configuration.RetrofitConfiguration;
import com.softserve.academy.mosquito.network.service.UserService;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment {

    @ViewById(R.id.login_email)
    EditText email;

    @ViewById(R.id.password_login)
    EditText password;

    @Click()
    public void registrationButtonClicked() {
        getFragmentManager().beginTransaction().replace(R.id.fragments_container,
                new RegistrationFragment_(), "Registration fragment").addToBackStack("Registration fragment").commit();
    }

    @Click
    public void loginButtonClicked() {

        User user = new User(
                email.getText().toString(),
                password.getText().toString()
        );

        Log.d("User loginnig", user.toString());

        UserService userService = RetrofitConfiguration.getRetrofit().create(UserService.class);
        Call<User> login = userService.login(user);

        login.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    SharedPreferences.Editor preferences = getActivity().getSharedPreferences("Credentials",Context.MODE_PRIVATE).edit();
                    preferences.putString("Authorization", response.headers().get("Authorization"));
                    preferences.putLong("userId",response.body().getId());
                    preferences.apply();
                    Intent intent = new Intent(getActivity(), TaskActivity_.class);
                    startActivity(intent);
                }else
                    Toast.makeText(getActivity(), "Login data are not correct!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
