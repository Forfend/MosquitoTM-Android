package com.softserve.academy.mosquito.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("estimation")
    @Expose
    private Long estimation;

    @SerializedName("priority")
    @Expose
    private String priority;

    @SerializedName("status")
    @Expose
    private String status;

    public Task() {
    }

    public Task(String name, Long estimation, String priority, String status) {
        this.name = name;
        this.estimation = estimation;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEstimation() {
        return estimation;
    }

    public void setEstimation(Long estimation) {
        this.estimation = estimation;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
