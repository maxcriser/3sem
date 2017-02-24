package com.maxcriser.tweets_android.handler;

import com.maxcriser.tweets_android.model.PointModel;

import java.util.ArrayList;
import java.util.List;

public final class PointsHandler {

    public static List<PointModel> getListPointsFromArrayStrings(final String[] points) {
        final List<PointModel> pointsList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            final String[] line = points[i].split(",");
            final PointModel newPointModel = new PointModel(line[0].toLowerCase(), Double.parseDouble(line[1]));
            pointsList.add(newPointModel);
        }
        return pointsList;
    }

}
