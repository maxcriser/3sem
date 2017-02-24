package com.maxcriser.tweets_android.model;

import android.os.Environment;
import android.util.Log;

import com.maxcriser.tweets_android.handler.PointsHandler;
import com.maxcriser.tweets_android.manager.TweetFileManager;

import java.io.File;
import java.util.List;

final class PointsTableModel {

    private static List<PointModel> sMPointModelList;
    public static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tweets_folder";

    private static List<PointModel> getPointList() {
        if (sMPointModelList == null) {
            Log.d("xXx", "GET LIST OF POINTS");
            final File file = new File(path + "/sentiments.csv");
            final String[] list = TweetFileManager.Load(file);
            sMPointModelList = PointsHandler.getListPointsFromArrayStrings(list);
            return sMPointModelList;
        } else {
            return sMPointModelList;
        }
    }

    static double getPoints(final List<WordModel> pWordModels) {
        double result = 0.0;
        final List<PointModel> list = getPointList();

        for (int i = 0; i < pWordModels.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                String wordsWord = pWordModels.get(i).getWord();
                String listWord = list.get(j).getWord();
                if (wordsWord.equals(listWord)) {
                    result += list.get(j).getPoints();
                    break;
                }
            }
        }
        Log.d("xXx", "SET POINTS FOR TWEET");
        return result;
    }

}
