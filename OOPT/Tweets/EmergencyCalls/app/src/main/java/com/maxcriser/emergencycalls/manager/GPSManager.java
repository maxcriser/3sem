package com.maxcriser.emergencycalls.manager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

public final class GPSManager {

    public static Location getGPS(final Context context) {
        final LocationManager lm =
                (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        if (InternetManager.hasConnection(context)) {
            return lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        } else {
            return lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
    }
}
