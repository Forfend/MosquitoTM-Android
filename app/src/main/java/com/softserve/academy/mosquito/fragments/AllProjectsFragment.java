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

@EFragment(R.layout.fragment_all_projects)
public class AllProjectsFragment extends Fragment {

    private ProjectsAdapter projectsAdapter;

    @ViewById(R.id.adapter_tasks)
    RecyclerView recyclerView;

    @AfterViews
    public void getProjects() {
        TaskService service = RetrofitConfiguration.getRetrofit().create(TaskService.class);
        SharedPreferences preferences = getActivity().getSharedPreferences("Credentials", Context.MODE_PRIVATE);

        Call<List<Project>> call = service.getProjects(preferences.getString("Authorization",""));

        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                List<Project> projects = response.body();
                projectsAdapter = new ProjectsAdapter(projects);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(projectsAdapter);
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(getContext(), "Connection failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
