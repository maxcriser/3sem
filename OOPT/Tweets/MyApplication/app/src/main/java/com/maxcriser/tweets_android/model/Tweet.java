package com.maxcriser.tweets_android.model;

public class Tweet {

    private final TweetLocation location;
    private final String unknownNumber;
    private final String date;
    private final String textTweet;

    public Tweet(final String latitude, final String longitude, final String unknownNumber,
                 final String date, final String textTweet) {
        location = new TweetLocation(latitude, longitude);
        this.unknownNumber = unknownNumber;
        this.date = date;
        this.textTweet = textTweet;
    }

    public TweetLocation getLocation() {
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