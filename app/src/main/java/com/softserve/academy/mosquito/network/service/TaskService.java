package com.softserve.academy.mosquito.network.service;

import com.softserve.academy.mosquito.model.Task;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskService {

    @GET("/tasks/2")
    Call<Task> getAllTask();

}
