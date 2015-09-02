package com.plugin.Roaming;

import org.json.JSONArray;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

public class RoamingPlugin extends CordovaPlugin {

    ConnectivityManager sockMan;

    TelephonyManager telephonyManager;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.sockMan = (ConnectivityManager) cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        this.telephonyManager = (TelephonyManager) cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        PluginResult.Status status = PluginResult.Status.OK;
        boolean result = false;

        if (action.equals("get")) {
            NetworkInfo info = sockMan.getActiveNetworkInfo();

            if (info != null) {
                result = info.isRoaming();
                Log.e("Roaming", "ConnectivityManager" + result);
            }
            else {
               status = PluginResult.Status.ERROR;
            }

        }
        // @see: http://developer.android.com/reference/android/net/NetworkInfo.html#isRoaming()
        else if(action.equals("getNetworkRoaming")){
            try {
                result = telephonyManager.isNetworkRoaming();
                Log.e("Roaming", "TelephonyManager " + result);
            } catch (Exception e) {
                status = PluginResult.Status.ERROR;
            }
        }
        else {
            status = PluginResult.Status.INVALID_ACTION;
        }
        callbackContext.sendPluginResult(new PluginResult(status, result));
        return true;
    }
}
