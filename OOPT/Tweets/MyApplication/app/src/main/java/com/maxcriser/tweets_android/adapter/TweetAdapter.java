package com.maxcriser.tweets_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxcriser.tweets_android.R;
import com.maxcriser.tweets_android.model.Tweet;
import com.maxcriser.tweets_android.viewHolder.TweetHolder;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetHolder> {

    private final List<Tweet> tweetsList;
    private final Context mContext;

    public TweetAdapter(final List<Tweet> tweetList, final Context pContext) {
        this.tweetsList = tweetList;
        this.mContext = pContext;
    }

    @Override
    public TweetHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tweet, parent, false);

        return new TweetHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TweetHolder holder, final int position) {
        final Tweet tweet = tweetsList.get(position);
        holder.mState.setText(tweet.getLocation().getState(mContext));
        holder.mTextView.setText(tweet.getTextTweet());
        holder.mLongitude.setText(tweet.getLocation().getLongitude());
        holder.mLatitude.setText(tweet.getLocation().getLatitude());
        holder.mDate.setText(tweet.getDate());
    }

    @Override
    public int getItemCount() {
        return tweetsList.size();
    }
}