package com.maxcriser.tweets_android.model;

public class PointModel {

    private String word;
    private double points;

    public PointModel(String word, double points) {
        this.word = word;
        this.points = points;
    }

    public String getWord() {
        return word;
    }

    public double getPoints() {
        return points;
    }
}
