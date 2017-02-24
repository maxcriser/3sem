package com.maxcriser.tweets_android.model;

public class StateModel {

    private final String code;
    private final String stateName;
    private final double latitude;
    private final double longitude;
    private double value;

    public StateModel(final String code, final String stateName, final double value,
                      final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.code = code;
        this.value = value;
        this.stateName = stateName;
    }

    public void addPoints(final double pValue) {
        value += pValue;
    }

    public String getCode() {
        return code;
    }

    public String getStateName() {
        return stateName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getPoints() {
        return value;
    }
}
