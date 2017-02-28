package com.maxcriser.tweets_android.model;

import android.os.Environment;
import android.util.Log;

import com.maxcriser.tweets_android.handler.PointsHandler;
import com.maxcriser.tweets_android.manager.TweetFileManager;

import java.io.File;
import java.util.List;

final class PointsTableHandler {

    private static List<PointModel> sPointModelList;
    public static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tweets_folder";

    private static List<PointModel> getPointList() {
        if (sPointModelList == null) {
            final File file = new File(path + "/sentiments.csv");
            final String[] list = TweetFileManager.Load(file);
            sPointModelList = PointsHandler.getListPointsFromArrayStrings(list);
            return sPointModelList;
        } else {
            return sPointModelList;
        }
    }

    static double getPoints(final List<WordModel> pWordModels) {
        final List<PointModel> list = getPointList();
        int countMatches = 0;
        double result = 0.0;
        // you binary-search or hashtable
        for (int i = 0; i < pWordModels.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (pWordModels.get(i).getWord().equals(list.get(j).getWord())) {
                    result += list.get(j).getPoints();
                    countMatches++;
                    Log.d("INFO", "result+= " + result + " : countMatches= " + countMatches);
                    break;
                }
            }
        }
        return (countMatches == 0) ? result : result/countMatches;
    }
}