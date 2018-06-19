package com.softserve.academy.mosquito.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("priorityDto")
    @Expose
    private Priority priority;

    @SerializedName("statusDto")
    @Expose
    private Status status;

    public Project() {
    }

    public Project(String name, Priority priority, Status status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
