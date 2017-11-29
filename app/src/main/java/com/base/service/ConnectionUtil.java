package com.base.service;

import android.content.Context;
import android.net.ConnectivityManager;
import com.base.App;

/**
 * Created by ferhat on 11/21/2017.
 */

public class ConnectionUtil {
    public static boolean isNetworkConnected() {
        if (((ConnectivityManager) App.appComponent.application().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null) {
            return true;
        } else return false;
    }
}