package com.maxcriser.tweets_android.utils;

import com.maxcriser.tweets_android.manager.TweetFileManager;
import com.maxcriser.tweets_android.model.Tweet;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TweetsReader {

    public static List<Tweet> getListTweet(final String path) {
        final File file = new File(path);
        final String[] loadText = TweetFileManager.Load(file);
        final List<String> tweetStrings = new ArrayList<>(Arrays.asList(loadText));

        final List<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < tweetStrings.size(); i++) {
            final String[] split = tweetStrings.get(i).split("\t");
            String coordin = split[0];
            coordin = coordin.replace("[", "");
            coordin = coordin.replace("]", "");
            coordin = coordin.replace(" ", "");
            final String[] coordinSplit = coordin.split(",");
            final String latitude = coordinSplit[0];
            final String longitude = coordinSplit[1];
            final String number = split[1];
            final String date = split[2];
            final String textTweet = split[3];
            final Tweet tweet = new Tweet(latitude, longitude, number, date, textTweet);
            tweets.add(tweet);
        }
        return tweets;
    }
}