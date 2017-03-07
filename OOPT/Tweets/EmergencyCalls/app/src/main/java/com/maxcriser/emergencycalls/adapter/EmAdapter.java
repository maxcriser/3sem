package com.maxcriser.emergencycalls.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxcriser.emergencycalls.R;
import com.maxcriser.emergencycalls.model.Em;
import com.maxcriser.emergencycalls.viewHolder.EmViewHolder;

import java.util.List;

public class EmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Em> items;
    private Context mContext;

    public EmAdapter(final Context pContext, final List<Em> items) {
        this.items = items;
        this.mContext = pContext;
    }

    @Override
    public int getItemViewType(final int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        view.setTag(view);
        return new EmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Em item = items.get(position);
        final EmViewHolder vh = (EmViewHolder) holder;
        vh.titleView.setText(item.getTitle());
        vh.descriptionView.setText(item.getDescription());
        if (item.getTitle().startsWith(mContext.getString(R.string.fire_department))) {
            vh.image.setBackgroundResource(R.drawable.fire);
        } else if (item.getTitle().startsWith(mContext.getString(R.string.ambulance))) {
            vh.image.setBackgroundResource(R.drawable.ambulance);
        } else if (item.getTitle().startsWith(mContext.getString(R.string.police))) {
            vh.image.setBackgroundResource(R.drawable.police);
        } else if (item.getTitle().startsWith(mContext.getString(R.string.sos))) {
            vh.image.setBackgroundResource(R.drawable.sos);
        } else {
            vh.image.setBackgroundResource(R.drawable.account_circle);
        }
        vh.data = item;
    }
}