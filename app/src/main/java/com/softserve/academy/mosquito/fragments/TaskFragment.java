package com.softserve.academy.mosquito.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.adapter.TaskAdapter;
import com.softserve.academy.mosquito.model.Task;
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

    private TaskAdapter taskAdapter;

    @ViewById(R.id.adapter_my_tasks)
    RecyclerView recyclerView;

    @ViewById
    TextView taskInfo;

    @AfterViews
    public void getMyTasks() {
        TaskService taskService = RetrofitConfiguration.getRetrofit().create(TaskService.class);
        SharedPreferences preferences = getActivity().getSharedPreferences("Credentials", Context.MODE_PRIVATE);

        Call<List<Task>> tasks = taskService.getMyTasks(preferences.getString("Authorization", ""),
                preferences.getLong("userId", -1));

        tasks.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                if (response.isSuccessful() && !response.body().isEmpty()) {
                    List<Task> myTasks = response.body();
                    Log.d("MyTasks",myTasks.toString());
                    taskAdapter = new TaskAdapter(myTasks);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());

                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(taskAdapter);
                } else
                    taskInfo.setText("You don`t have any tasks");
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
