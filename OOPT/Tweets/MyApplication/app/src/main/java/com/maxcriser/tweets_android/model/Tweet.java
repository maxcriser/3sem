package com.maxcriser.tweets_android.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.maxcriser.tweets_android.handler.TweetHandler;

import java.util.List;

public class Tweet {

    private final TweetLocationModel location;
    private final String unknownNumber;
    private final String date;
    private final String textTweet;
    private double points;
    private List<WordModel> mWordModels;

    public Tweet(final Context pContext, final String latitude, final String longitude, final String unknownNumber,
                 final String date, final String textTweet) {
        this.mWordModels = TweetHandler.getListWordsFromText(textTweet);
        this.points = PointsTableHandler.getPoints(mWordModels);
        if(points<-1 || points >1){
            Toast.makeText(pContext, "ERRORR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
        }
        Log.d("INFO", "result/countMatches= " + points);
        this.location = new TweetLocationModel(latitude, longitude);
        location.state = location.getState(pContext);
        this.unknownNumber = unknownNumber;
        this.date = date;
        this.textTweet = textTweet;
    }

    public List<WordModel> getWordModels() {
        return mWordModels;
    }

    public double getPoints() {
        return points;
    }

    public TweetLocationModel getLocation() {
        return location;
    }

    public String getUnknownNumber() {
        return unknownNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTextTweet() {
        return textTweet;
    }
}