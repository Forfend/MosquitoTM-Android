package com.softserve.academy.mosquito.network.service;

import com.softserve.academy.mosquito.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskService {

    @GET("/projects")
    Call<List<Project>> getProjects();

}
