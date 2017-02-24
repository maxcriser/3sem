package com.maxcriser.tweets_android.async;

public interface OnResultCallback<Result, Progress> extends ProgressCallback<Progress> {

    void onSuccess(Result pResult);

    void onError(Exception pE);

}
