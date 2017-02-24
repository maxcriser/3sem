package com.maxcriser.tweets_android.async;

public interface Task<Params, Progress, Result> {

    Result doInBackground(Params pParams, ProgressCallback<Progress> pProgressProgressCallback) throws Exception;

}