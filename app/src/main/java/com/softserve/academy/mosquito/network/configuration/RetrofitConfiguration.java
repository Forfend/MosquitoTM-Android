package com.softserve.academy.mosquito.network.configuration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguration {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://8fb3b34f.ngrok.io";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
