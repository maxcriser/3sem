package com.maxcriser.tweets_android.model;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.maxcriser.tweets_android.constants.messages.LOCATION_IS_NOT_FOUND;

public class TweetLocationModel {

    private final double latitude;
    private final double longitude;
    public String state;

    TweetLocationModel(final String latitude, final String longitude) {
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }

    String getState(final Context pContext) {
        final Geocoder geocoder = new Geocoder(pContext, Locale.getDefault());
        try {
            final Address address = geocoder.getFromLocation(latitude, longitude, 1).get(0);
            return getStateCode(address.toString()).replace(", ", "");
//            return address.getAdminArea();
        } catch (final IOException pE) {
            return LOCATION_IS_NOT_FOUND;
        }
    }

    private String getStateCode(final CharSequence text) {
        return getRegexString(text, ", [A-Z]{2}");
    }

    private String getRegexString(final CharSequence text, final String regex) {
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(text);

        return (matcher.find() ? matcher.group() : "**");
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}