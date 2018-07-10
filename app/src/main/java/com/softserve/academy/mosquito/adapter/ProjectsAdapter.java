package com.softserve.academy.mosquito.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.model.Project;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.TaskViewHolder> {

    private List<Project> projects;

    public ProjectsAdapter(List<Project> projects) {
        this.projects = projects;
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
        holder.projectName.setText(projects.get(position).getName());
        holder.projectPriority.setText(projects.get(position).getPriority().getTitle());
        holder.projectStatus.setText(projects.get(position).getStatus().getStatus());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView projectName;
        TextView projectPriority;
        TextView projectStatus;

        public TaskViewHolder(View itemView) {
            super(itemView);
            projectName = itemView.findViewById(R.id.task_name);
            projectPriority = itemView.findViewById(R.id.task_priority);
            projectStatus = itemView.findViewById(R.id.task_status);
        }
    }
}
