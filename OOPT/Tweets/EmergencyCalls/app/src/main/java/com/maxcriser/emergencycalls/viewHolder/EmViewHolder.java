package com.maxcriser.emergencycalls.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxcriser.emergencycalls.R;
import com.maxcriser.emergencycalls.SwipeToAction;
import com.maxcriser.emergencycalls.model.Em;


public class EmViewHolder extends SwipeToAction.ViewHolder<Em> {
        public TextView titleView;
        public TextView descriptionView;
        public ImageView image;

        public EmViewHolder(final View v) {
            super(v);
            titleView = (TextView) v.findViewById(R.id.title);
            descriptionView = (TextView) v.findViewById(R.id.description);
            image = (ImageView) v.findViewById(R.id.image);
        }
    }