package com.softserve.academy.mosquito.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.adapter.ProjectsAdapter;
import com.softserve.academy.mosquito.model.Project;
import com.softserve.academy.mosquito.network.configuration.RetrofitConfiguration;
import com.softserve.academy.mosquito.network.service.TaskService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EFragment(R.layout.fragment_my_projects)
public class MyProjectsFragment extends Fragment {

    private ProjectsAdapter projectsAdapter;

    @ViewById(R.id.adapter_projects)
    RecyclerView recyclerView;

    @AfterViews
    public void getMyProjects() {
        final TaskService projects = RetrofitConfiguration.getRetrofit().create(TaskService.class);
        SharedPreferences preferences = getActivity().getSharedPreferences("Credentials", Context.MODE_PRIVATE);

        Call<List<Project>> call = projects.getAllProjectsForOwner(preferences.getString("Authorization", ""),
                preferences.getLong("userId", 0));
        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                if (response.isSuccessful()) {
                    List<Project> allProjects = response.body();
                    projectsAdapter = new ProjectsAdapter(allProjects);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(projectsAdapter);
                } else
                    Toast.makeText(getContext(), "Failed retrieve projects!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}