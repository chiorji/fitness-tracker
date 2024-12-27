package com.fitnesstracker;

public class ResultModel {
    private final double unestimated, estimated;

    public ResultModel(double thrUnestimated, double thrEstimated) {
        this.unestimated = thrUnestimated;
        this.estimated = thrEstimated;
    }

    public double getThrUnestimated() {
        return this.unestimated;
    }

    public double getThrEstimated() {
        return this.estimated;
    }
}
