package com.maxcriser.tweets_android.model;

public class PointModel {

    private final String word;
    private final double points;

    public PointModel(final String word, final double points) {
        this.word = word;
        this.points = points;
    }

    String getWord() {
        return word;
    }

    public double getPoints() {
        return points;
    }
}
