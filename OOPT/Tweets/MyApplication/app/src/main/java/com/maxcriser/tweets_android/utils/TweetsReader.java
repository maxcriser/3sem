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
        String[] split;
        String[] coordinatesSplit;
        Tweet tweet;
        String coordinates;

        for (int i = 0; i < tweetStrings.size(); i++) {
            split = tweetStrings.get(i).split("\t");
            coordinates = split[0].replaceAll("[\\[\\] ]", "");
            coordinatesSplit = coordinates.split(",");
            tweet = new Tweet(pContext, coordinatesSplit[0], coordinatesSplit[1], split[1], split[2], split[3]);
            Log.d("INFO", i + " tweet added");
            tweets.add(tweet);
        }
        return tweets;
    }
}