package com.maxcriser.emergencycalls.util;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class CustomStringPicker extends LinearLayout {

    private Object mInstance;
    private Class<?> mClazz;
    private String[] values;
    private static final int SDK_VERSION;
    private static final String PICKER_CLASS;

    static {
        SDK_VERSION = Build.VERSION.SDK_INT;
        final String ANDROID_WIDGET_NUMBER_PICKER = "android.widget.NumberPicker";
        final String COM_ANDROID_INTERNAL_WIDGET_NUMBER_PICKER = "com.android.internal.widget.NumberPicker";
        PICKER_CLASS = SDK_VERSION < Build.VERSION_CODES.FROYO ? COM_ANDROID_INTERNAL_WIDGET_NUMBER_PICKER : ANDROID_WIDGET_NUMBER_PICKER;
    }

    public CustomStringPicker(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void setCurrent(final int current) {
        final String SET_VALUE = "setValue";
        final String SET_CURRENT = "setCurrent";
        final String methodName = isUnderHoneyComb() ? SET_CURRENT : SET_VALUE;
        try {
            final Method method = mClazz.getMethod(methodName, int.class);
            method.invoke(mInstance, current);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getCurrent() {
        final String GET_VALUE = "getValue";
        final String GET_CURRENT = "getCurrent";
        final String methodName = isUnderHoneyComb() ? GET_CURRENT : GET_VALUE;
        try {
            final Method method = mClazz.getMethod(methodName);
            return (Integer) method.invoke(mInstance);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCurrentValue() {
        return values[getCurrent()];
    }

    public void setValues(final String[] values) {
        this.values = values;
        if (isUnderHoneyComb()) {
            try {
                final String SET_RANGE = "setRange";
                final Method method = mClazz.getMethod(SET_RANGE, int.class, int.class, String[].class);
                method.invoke(mInstance, 0, values.length - 1, values);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                final String SET_MAX_VALUE = "setMaxValue";
                mClazz.getMethod(SET_MAX_VALUE, int.class).invoke(mInstance, values.length - 1);
                final String SET_MIN_VALUE = "setMinValue";
                mClazz.getMethod(SET_MIN_VALUE, int.class).invoke(mInstance, 0);
                final String SET_DISPLAYED_VALUES = "setDisplayedValues";
                mClazz.getMethod(SET_DISPLAYED_VALUES, String[].class).invoke(mInstance, new Object[]{values});
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setValues(final List<String> values) {
        this.values = values.toArray(new String[values.size()]);
        setValues(this.values);
    }

    private void init(final Context context, final AttributeSet attrs) {
        try {
            final Class<?> clazz = context.getClassLoader().loadClass(PICKER_CLASS);
            final Constructor<?> constructor = clazz.getConstructor(Context.class, AttributeSet.class);
            mInstance = constructor.newInstance(context, attrs);
            mClazz = mInstance.getClass();

            final String methodName = "setDescendantFocusability";
            final Method method = mClazz.getMethod(methodName, int.class);
            method.invoke(mInstance, NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
        addView((View) mInstance);
        setOrientation(VERTICAL);
    }

    private static boolean isUnderHoneyComb() {
        return SDK_VERSION < Build.VERSION_CODES.HONEYCOMB;
    }
}