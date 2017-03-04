package com.maxcriser.emergencycalls.manager;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.LinkedList;
import java.util.List;

public final class ProfileManager {

    public static String getUserMail(final Context pContext) {
        final AccountManager manager = AccountManager.get(pContext);
        if (ActivityCompat.checkSelfPermission(pContext, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
            final Account[] accounts = manager.getAccountsByType("com.google");
            final List<String> possibleEmails = new LinkedList<>();

            for (final Account account : accounts) {
                // TODO: Check possibleEmail against an email regex or treat
                // account.name as an email address only for certain account.type values.
                possibleEmails.add(account.name);
            }

            if (!possibleEmails.isEmpty() && possibleEmails.get(0) != null) {
                return possibleEmails.get(0);
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

}
