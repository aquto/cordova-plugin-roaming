package com.plugin.Roaming;


import org.json.JSONArray;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

public class RoamingPlugin extends CordovaPlugin {

    ConnectivityManager sockMan;
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.sockMan = (ConnectivityManager) cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        PluginResult.Status status = PluginResult.Status.OK;
        boolean result = false;

        NetworkInfo info = sockMan.getActiveNetworkInfo();

        if (action.equals("get")) {
            if (info != null) {
                result = info.isRoaming();
            }
            else {
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
