package com.maxcriser.tweets_android.utils;

import android.content.Context;
import android.util.Log;

import com.maxcriser.tweets_android.manager.TweetFileManager;
import com.maxcriser.tweets_android.model.Tweet;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TweetsReader {

    private static String[] getArrayStrings(final String path) {
        final File file = new File(path);
        return TweetFileManager.Load(file);
    }

    public static List<Tweet> getListTweet(final Context pContext, final String path) {
        final List<String> tweetStrings = new ArrayList<>(Arrays.asList(getArrayStrings(path)));
        final List<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < tweetStrings.size(); i++) {
            final String[] split = tweetStrings.get(i).split("\t");
            String coordinates = split[0];
            coordinates = coordinates.replace("[", "");
            coordinates = coordinates.replace("]", "");
            coordinates = coordinates.replace(" ", "");
            final String[] coordinatesSplit = coordinates.split(",");
            final String latitude = coordinatesSplit[0];
            final String longitude = coordinatesSplit[1];
            final String number = split[1];
            final String date = split[2];
            final String textTweet = split[3];
            final Tweet tweet = new Tweet(pContext, latitude, longitude, number, date, textTweet);
            Log.d("xXx", i + " tweet added");
            tweets.add(tweet);
        }
        return tweets;
    }
}