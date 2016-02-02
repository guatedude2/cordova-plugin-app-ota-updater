package org.cordova.plugin.labs.AppOTAUpdater;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

public class AppOTAUpdaterPlugin extends CordovaPlugin {

  public static final String TAG = "AppOTAUpdaterPlugin";
  protected static CordovaInterface cordovaInstance = null;
  private static CordovaWebView webView = null;

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    AppOTAUpdaterPlugin.webView = super.webView;
    AppOTAUpdaterPlugin.cordovaInstance = super.cordova;

    Log.v(TAG, "--- Init");
  }

  @Override
  public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

    Log.v(TAG, "Executing (" + action + ")");

    if (action.equals("downloadAndInstall")){
      downloadAndInstall(data, callbackContext);
    } else {
      return false;
    }

    return true;

  }

   private void downloadAndInstall(JSONArray data, CallbackContext callbackContext) {
    UpdateApp updateApp = new UpdateApp();
    updateApp.setContext(this.cordova.getActivity().getApplicationContext());
    updateApp.setCallback(callbackContext);
    updateApp.execute(data.optString(0));
  }
}
