package com.softserve.academy.mosquito.network.service;

import com.softserve.academy.mosquito.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface TaskService {

    @GET("api/projects")
    Call<List<Project>> getProjects(@Header("Authorization") String token);

    @GET("api/projects/owner/{owner_id}")
    Call<List<Project>> getAllProjectsForOwner(@Header("Authorization") String token,@Path("owner_id") long id);

}
