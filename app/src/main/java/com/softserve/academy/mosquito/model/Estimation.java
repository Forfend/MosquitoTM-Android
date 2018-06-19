package com.softserve.academy.mosquito.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estimation {

    @SerializedName("estimationDto")
    @Expose
    private Log estimation;

    public Estimation() {
    }

    public Estimation(Log estimation) {
        this.estimation = estimation;
    }

    public Log getEstimation() {
        return estimation;
    }

    public void setEstimation(Log estimation) {
        this.estimation = estimation;
    }
}
