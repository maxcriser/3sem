package com.maxcriser.tweets_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxcriser.tweets_android.R;
import com.maxcriser.tweets_android.model.StateModel;
import com.maxcriser.tweets_android.viewHolder.StatePointsHolder;

import java.util.List;

public class StatePointsAdapter extends RecyclerView.Adapter<StatePointsHolder> {

    private final List<StateModel> mStateModelList;
    private final Context mContext;

    public StatePointsAdapter(final List<StateModel> pStateModelList, final Context pContext) {
        this.mStateModelList = pStateModelList;
        this.mContext = pContext;
    }

    @Override
    public StatePointsHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_location, parent, false);

        return new StatePointsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StatePointsHolder holder, final int position) {
        final StateModel state = mStateModelList.get(position);

        holder.pointsState.setText(String.valueOf(state.getValue()));
        holder.codeState.setText(state.getCode());
        holder.nameState.setText(state.getStateName());
    }

    @Override
    public int getItemCount() {
        return mStateModelList.size();
    }
}