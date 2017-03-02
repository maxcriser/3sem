package com.maxcriser.emergencycalls.view.labels;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextRobotoRegular extends EditText {

    public EditTextRobotoRegular(final Context context) {
        super(context);
        init();
    }

    public EditTextRobotoRegular(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextRobotoRegular(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            final Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
            setTypeface(tf);
        }
    }
}
