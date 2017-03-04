package com.maxcriser.emergencycalls.manager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;

public class PhoneManager {

    public static void sendSMS(final String phoneNo, final String msg) throws Exception {
//        final SmsManager smsManager = SmsManager.getDefault();
//        smsManager.sendTextMessage(phoneNo, null, msg, null, null);
    }

    public static void makeCall(final Context pContext, final String number) throws Exception {
//        final Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
//        if (ActivityCompat.checkSelfPermission(pContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        pContext.startActivity(intent);
    }
}
