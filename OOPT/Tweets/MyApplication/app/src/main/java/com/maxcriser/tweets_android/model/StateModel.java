package com.maxcriser.tweets_android.model;

public class StateModel {

    private String code;
    private String stateName;
    private double value;

    public StateModel(final String code, final String stateName, final double value) {
        this.code = code;
        this.value = value;
        this.stateName = stateName;
    }

    public void addValue(double pValue) {
        value += pValue;
    }

    public String getCode() {
        return code;
    }

    public String getStateName() {
        return stateName;
    }

    public double getValue() {
        return value;
    }
}
