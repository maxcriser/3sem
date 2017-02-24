package com.maxcriser.tweets_android.handler;

import com.maxcriser.tweets_android.model.WordModel;

import java.util.ArrayList;
import java.util.List;

public final class TweetHandler {

    public static List<WordModel> getListWordsFromText(final String text) {
        final List<WordModel> wordModels = new ArrayList<>();
        WordModel newWordModel;
        final String[] wordsStrings = text.split("[() \"/,;{}:.!?+_#@$%^&*='><\\s]+");
        for (int i = 0; i < wordsStrings.length; i++) {
            newWordModel = new WordModel(wordsStrings[i].toLowerCase());
            wordModels.add(newWordModel);
        }
        return wordModels;
    }
}