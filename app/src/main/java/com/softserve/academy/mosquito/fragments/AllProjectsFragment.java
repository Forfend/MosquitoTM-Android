package com.softserve.academy.mosquito.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.adapter.TaskAdapter;
import com.softserve.academy.mosquito.model.Task;
import com.softserve.academy.mosquito.network.configuration.RetrofitConfiguration;
import com.softserve.academy.mosquito.network.service.TaskService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EFragment(R.layout.fragment_all_projects)
public class AllProjectsFragment extends Fragment {

    private TaskAdapter taskAdapter;

    @ViewById(R.id.adapter_tasks)
    RecyclerView recyclerView;

    @AfterViews
    public void getTasks() {
        TaskService service = RetrofitConfiguration.getRetrofit().create(TaskService.class);
        Call<Task> call = service.getAllTask();

        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                Task task = response.body();
                List<Task> tasks = new ArrayList<>();
                tasks.add(task);
                taskAdapter = new TaskAdapter(tasks);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(taskAdapter);
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(getContext(), "Connection failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
