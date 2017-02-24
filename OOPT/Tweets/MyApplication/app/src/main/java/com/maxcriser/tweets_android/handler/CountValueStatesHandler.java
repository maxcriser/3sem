package com.maxcriser.tweets_android.handler;

import com.maxcriser.tweets_android.constants.StatesConstants;
import com.maxcriser.tweets_android.model.StateModel;
import com.maxcriser.tweets_android.model.Tweet;

import java.util.List;

public class CountValueStatesHandler {

    private List<Tweet> mTweetList;
    private List<StateModel> mStateModelList;

    public CountValueStatesHandler(final List<Tweet> pTweetList) {
        this.mTweetList = pTweetList;
    }

    public List<StateModel> calculationStateValues() {
        final List<StateModel> pStateModels = StatesConstants.states;

        for (int i = 0; i < mTweetList.size(); i++) {
            for (int j = 0; j < pStateModels.size(); j++) {
                final Tweet checkTweet = mTweetList.get(i);
                final StateModel checkStateModel = pStateModels.get(j);
                if (checkTweet.getLocation().state.equals(checkStateModel.getCode())) {
                    checkStateModel.addPoints(checkTweet.getPoints());
                }
            }
        }
        return pStateModels;
    }

    public List<StateModel> getStateModelList() {
        if (mStateModelList == null) {
            mStateModelList = calculationStateValues();
            return mStateModelList;
        } else {
            return mStateModelList;
        }
    }
}