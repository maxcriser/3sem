package com.maxcriser.emergencycalls.view.labels;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

public class ButtonRobotoMedium extends Button {

    public ButtonRobotoMedium(final Context context) {
        super(context);
        init();
    }

    public ButtonRobotoMedium(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonRobotoMedium(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            final Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Medium.ttf");
            setTypeface(tf);
        }
    }
}
