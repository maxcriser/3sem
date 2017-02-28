package com.maxcriser.emergencycalls.viewHolder;

import android.view.View;
import android.widget.TextView;

import com.maxcriser.emergencycalls.R;
import com.maxcriser.emergencycalls.model.Em;

import co.dift.ui.SwipeToAction;

public class EmViewHolder extends SwipeToAction.ViewHolder<Em> {
        public TextView titleView;

        public EmViewHolder(final View v) {
            super(v);
            titleView = (TextView) v.findViewById(R.id.title);
        }
    }