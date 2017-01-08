package com.wildcoder.internal.emailing.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class CheckNetwork {

    /**
     * @param c
     * @return true if connected to active internet
     */
    public static boolean isInternetConnected(Context c) {
        if (c == null)
            return false;
        ConnectivityManager cm = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        return cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected();
    }
}
