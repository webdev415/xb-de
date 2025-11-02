package com.mmbox.xbrowser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import p000.C1825ha;

/* loaded from: classes.dex */
public class BrowserReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (action.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
            return;
        }
        if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            if (((WifiManager) context.getSystemService(Context.WIFI_SERVICE)).isWifiEnabled()) {
                if (BrowserActivity.getActivity() == null || networkInfo == null) {
                    return;
                }
            } else if (BrowserActivity.getActivity() == null || networkInfo == null) {
                return;
            }
        } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
            if (networkInfo == null) {
                return;
            }
            Log.i("wifi-state", "============  wifi state" + networkInfo.getState());
            if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                C1825ha.m7824d().m7825a();
                if (BrowserActivity.getActivity() == null) {
                    return;
                }
            } else if (networkInfo.getState().equals(NetworkInfo.State.SUSPENDED)) {
                if (BrowserActivity.getActivity() == null) {
                    return;
                }
            } else if (!networkInfo.getState().equals(NetworkInfo.State.DISCONNECTED) || BrowserActivity.getActivity() == null) {
                return;
            }
        } else {
            if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (action.equals("android.intent.action.PROXY_CHANGE")) {
                    return;
                }
                if ((action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REMOVED")) && BrowserActivity.getActivity() != null) {
                    BrowserActivity.getActivity().m6218I0().mo6430h0();
                    return;
                }
                return;
            }
            if (networkInfo == null) {
                return;
            }
            Log.i("wifi-state", "============  wifi state" + networkInfo.getState());
            if (BrowserActivity.getActivity() == null) {
                return;
            }
        }
        BrowserActivity.getActivity().m6219I1(networkInfo.getState());
    }
}
