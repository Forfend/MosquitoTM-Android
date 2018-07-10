package com.softserve.academy.mosquito.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
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

@EFragment(R.layout.fragment_task)
public class TaskFragment extends Fragment {

    private ProjectsAdapter projectsAdapter;

    @ViewById(R.id.adapter_my_tasks)
    RecyclerView recyclerView;

    @ViewById
    TextView taskInfo;

    @AfterViews
    public void getMyTasks() {
        TaskService taskService = RetrofitConfiguration.getRetrofit().create(TaskService.class);
        SharedPreferences preferences = getActivity().getSharedPreferences("Credentials", Context.MODE_PRIVATE);

        Call<List<Project>> tasks = taskService.getMyTasks(preferences.getString("Authorization", ""),
                preferences.getLong("userId", -1));

        tasks.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                if (response.isSuccessful() && !response.body().isEmpty()) {
                    List<Project> myTasks = response.body();

                    projectsAdapter = new ProjectsAdapter(myTasks);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(projectsAdapter);
                } else
                    taskInfo.setText("You don`t have any tasks");
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
