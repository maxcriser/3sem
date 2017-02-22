package com.maxcriser.tweets_android.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.maxcriser.tweets_android.R;

public class TweetHolder extends RecyclerView.ViewHolder {

    public TextView mTextView;
    public TextView mDate;
    public TextView mLatitude;
    public TextView mLongitude;
    public TextView mState;

    public TweetHolder(final View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.text);
        mDate = (TextView) itemView.findViewById(R.id.date);
        mLatitude = (TextView) itemView.findViewById(R.id.latitude);
        mLongitude = (TextView) itemView.findViewById(R.id.longitude);
        mState = (TextView) itemView.findViewById(R.id.state);
    }
}
