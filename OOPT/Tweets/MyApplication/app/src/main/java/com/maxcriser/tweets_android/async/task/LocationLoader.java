package com.maxcriser.tweets_android.async.task;

import com.maxcriser.tweets_android.async.ProgressCallback;
import com.maxcriser.tweets_android.async.Task;
import com.maxcriser.tweets_android.model.Tweet;

public class LocationLoader implements Task<Tweet, String, String> {

    public LocationLoader() {
    }

    @Override
    public String doInBackground(final Tweet pTweet, final ProgressCallback<String> pStringProgressCallback) throws Exception {
        return "EMPTY STRING";
    }
}
