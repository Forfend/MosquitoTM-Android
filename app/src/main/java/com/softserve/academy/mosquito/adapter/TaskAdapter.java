package com.softserve.academy.mosquito.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.taskName.setText(tasks.get(position).getName());
        holder.taskEstimation.setText(tasks.get(position).getEstimation().toString());
        holder.taskPriority.setText(tasks.get(position).getPriority());
        holder.taskStatus.setText(tasks.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView taskName;
        TextView taskEstimation;
        TextView taskPriority;
        TextView taskStatus;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.task_name);
            taskEstimation = itemView.findViewById(R.id.task_estimation);
            taskPriority = itemView.findViewById(R.id.task_priority);
            taskStatus = itemView.findViewById(R.id.task_status);
        }
    }
}
