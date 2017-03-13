package com.maxcriser.emergencycalls.constants;

import android.Manifest;

import java.util.ArrayList;
import java.util.List;

public final class Permissions {

        public static List<String> permissions = new ArrayList<String>() {

            {
                add(Manifest.permission.ACCESS_FINE_LOCATION);
                add(Manifest.permission.CALL_PHONE);
                add(Manifest.permission.SEND_SMS);
                add(Manifest.permission.READ_CONTACTS);
            }

        };

}
