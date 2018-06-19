package com.softserve.academy.mosquito.network.service;

import com.softserve.academy.mosquito.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("/signup")
    Call<User> registration(@Body User user);

    @GET("/signin")
    Call<User> login(@Body User user);

}
