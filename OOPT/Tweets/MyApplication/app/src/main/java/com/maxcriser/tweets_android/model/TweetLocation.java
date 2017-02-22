package com.maxcriser.tweets_android.model;

import android.content.Context;
import android.location.Geocoder;

import java.io.IOException;
import java.util.Locale;

import static com.maxcriser.tweets_android.constants.messages.LOCATION_IS_NOT_FOUND;

public class TweetLocation {

    private final String latitude;
    private final String longitude;

    TweetLocation(final String latitude, final String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getState(final Context pContext) {
        final Geocoder geocoder = new Geocoder(pContext, Locale.getDefault());
        try {
            return geocoder.getFromLocation(Double.parseDouble(getLatitude()),
                    Double.parseDouble(getLongitude()), 1).get(0).getAdminArea();
        } catch (final IOException pE) {
            return LOCATION_IS_NOT_FOUND;
        }
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
