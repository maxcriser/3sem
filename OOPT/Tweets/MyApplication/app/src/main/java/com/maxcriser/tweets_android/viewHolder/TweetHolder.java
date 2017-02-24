package com.maxcriser.tweets_android.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.maxcriser.tweets_android.R;

public class TweetHolder extends RecyclerView.ViewHolder {

    public TextView mTextView;
    public TextView mDate;
    public TextView mState;
    public TextView points;

    public TweetHolder(final View itemView) {
        super(itemView);
        points = (TextView) itemView.findViewById(R.id.points);
        mTextView = (TextView) itemView.findViewById(R.id.text);
        mDate = (TextView) itemView.findViewById(R.id.date);
        mState = (TextView) itemView.findViewById(R.id.state);
    }
}
