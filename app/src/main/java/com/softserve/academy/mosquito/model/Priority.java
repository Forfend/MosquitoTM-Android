package com.softserve.academy.mosquito.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Priority {

    @SerializedName("title")
    @Expose
    private String title;

    public Priority() {
    }

    public Priority(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
