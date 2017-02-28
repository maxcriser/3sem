package com.maxcriser.tweets_android.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxcriser.tweets_android.R;

public class StatePointsHolder extends RecyclerView.ViewHolder {

    public TextView codeState;
    public TextView nameState;
    public TextView pointsState;
    public LinearLayout linearTable;

    public StatePointsHolder(final View itemView) {
        super(itemView);
        pointsState = (TextView) itemView.findViewById(R.id.value_table);
        codeState = (TextView) itemView.findViewById(R.id.code_table);
        nameState = (TextView) itemView.findViewById(R.id.state_name_table);
        linearTable = (LinearLayout) itemView.findViewById(R.id.linear_table);
    }
}
