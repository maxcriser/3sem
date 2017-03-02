package com.maxcriser.emergencycalls.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxcriser.emergencycalls.R;

/**
 * Created by yarolegovich on 16.04.2016.
 */
public class LovelyCustomDialog extends AbsLovelyDialog<LovelyCustomDialog> {

    private View addedView;
    private InstanceStateManager instanceStateManager;

    public LovelyCustomDialog(final Context context) {
        super(context);
    }

    public LovelyCustomDialog(final Context context, final int theme) {
        super(context, theme);
    }

    public LovelyCustomDialog setView(@LayoutRes final int layout) {
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        final ViewGroup parent = findView(R.id.ld_custom_view_container);
        addedView = inflater.inflate(layout, parent, true);
        return this;
    }

    public View getAddedView() {
        return addedView;
    }

    public LovelyCustomDialog setView(final View customView) {
        final ViewGroup container = findView(R.id.ld_custom_view_container);
        container.addView(customView);
        addedView = customView;
        return this;
    }

    public LovelyCustomDialog configureView(final ViewConfigurator configurator) {
        if (addedView == null) {
            throw new IllegalStateException(string(R.string.ex_msg_dialog_view_not_set));
        }
        configurator.configureView(addedView);
        return this;
    }

    public LovelyCustomDialog setListener(final int viewId, final View.OnClickListener listener) {
        return setListener(viewId, false, listener);
    }

    public LovelyCustomDialog setListener(final int viewId, final boolean dismissOnClick, final View.OnClickListener listener) {
        if (addedView == null) {
            throw new IllegalStateException(string(R.string.ex_msg_dialog_view_not_set));
        }
        final View.OnClickListener clickListener = new ClickListenerDecorator(listener, dismissOnClick);
        findView(viewId).setOnClickListener(clickListener);
        return this;
    }

    public LovelyCustomDialog setInstanceStateManager(final InstanceStateManager instanceStateManager) {
        this.instanceStateManager = instanceStateManager;
        return this;
    }

    @Override
    void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        instanceStateManager.saveInstanceState(outState);
    }

    @Override
    void restoreState(final Bundle savedState) {
        super.restoreState(savedState);
        instanceStateManager.restoreInstanceState(savedState);
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_custom;
    }

    public interface ViewConfigurator {
        void configureView(View v);
    }

    public interface InstanceStateManager {
        void saveInstanceState(Bundle outState);

        void restoreInstanceState(Bundle savedState);
    }
}
