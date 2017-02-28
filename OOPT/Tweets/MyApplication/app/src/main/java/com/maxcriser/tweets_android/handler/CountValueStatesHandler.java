package com.maxcriser.tweets_android.handler;

import android.graphics.Color;

import com.maxcriser.tweets_android.constants.StatesConstants;
import com.maxcriser.tweets_android.model.ColorModel;
import com.maxcriser.tweets_android.model.StateModel;
import com.maxcriser.tweets_android.model.Tweet;

import java.util.List;

public class CountValueStatesHandler {

    private List<Tweet> mTweetList;
    private List<StateModel> mStateModelList;

    public CountValueStatesHandler(final List<Tweet> pTweetList) {
        this.mTweetList = pTweetList;
    }

    private List<StateModel> calculationStateValues() {
        final List<StateModel> pStateModels = StatesConstants.states;

        for (int i = 0; i < pStateModels.size(); i++) {
            final StateModel checkStateModel = pStateModels.get(i);
            int countMatches = 0;
            for (int j = 0; j < mTweetList.size(); j++) {
                final Tweet checkTweet = mTweetList.get(j);
                if (checkTweet.getLocation().state.equals(checkStateModel.getCode())) {
                    checkStateModel.addPoints(checkTweet.getPoints());
                    countMatches++;
                }
            }

            double value = 0.0;
            double sad = 0.0;
            if (countMatches != 0) {
                double point = checkStateModel.getPoints() / (double) countMatches;
                checkStateModel.setPoints(point);
                sad = 255.0 * point;
                if(sad >= 0){
                    value = 255.0 - sad;
                } else {
                    value = 255.0 + sad;
                }
            }

            final ColorModel colorModel;
            if (sad < 0) {
                colorModel = new ColorModel(255, (int) value, (int) value);
            } else if (sad > 0) {
                colorModel = new ColorModel((int) value, 255, (int) value);
            } else {
                colorModel = new ColorModel(255, 255, 255);
            }
            checkStateModel.setColorModel(colorModel);
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