package com.base.service;

/**
 * Created by ferhat on 11/21/2017.
 */

public class ConnectionUtil {

    private static final ConnectionUtil ourInstance = new ConnectionUtil();

    public static ConnectionUtil getInstance() {
        return ourInstance;
    }

    private ConnectionUtil() {
    }

    public boolean isNetworkConnected(){
        //ConnectivityManager connectivityManager =(ConnectivityManager) App.application().getSystemService(Context.CONNECTIVITY_SERVICE);
        /*if (connectivityManager.getActiveNetworkInfo() != null){
            return true;
        }else return false;
    }*/
        return false;
    }
}
