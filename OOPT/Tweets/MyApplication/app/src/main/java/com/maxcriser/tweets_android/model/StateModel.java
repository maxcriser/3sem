package com.maxcriser.tweets_android.model;

public class StateModel {

    private final String code;
    private final String stateName;
    private final double latitude;
    private final double longitude;
    public double value;
    private ColorModel color;

    public StateModel(final String code, final String stateName, final double value,
                      final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.code = code;
        this.value = value;
        this.stateName = stateName;
    }

    public void setColorModel(final ColorModel color){
        this.color = color;
    }

    public void addPoints(final double pValue) {
        value += pValue;
    }

    public void setPoints(final double pValue) {
        value = pValue;
    }

    public void setValue(final double pValue) {
        value = pValue;
    }

    public void setColor(final ColorModel pColor) {
        color = pColor;
    }

    public ColorModel getColor() {

        return color;
    }

    public double getValue() {
        return value;
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
