package com.maxcriser.emergencycalls.view.labels;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewRobotoMedium extends TextView {

    public TextViewRobotoMedium(final Context context) {
        super(context);
        init();
    }

    public TextViewRobotoMedium(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewRobotoMedium(final Context context, final AttributeSet attrs, final int defStyleAttr) {
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
