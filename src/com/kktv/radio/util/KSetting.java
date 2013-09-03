package com.kktv.radio.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class KSetting {

	public static final String radioURL = "aHR0cDovL3J1c2hwbGF5ZXIuY29tL3dhcHN0cmVhbS5hc3B4P3Y9MS41NCZ0PTEmZz04JmFwcD0xMDAw";
	public static final String radioURLHead = "aHR0cDovL3J1c2hwbGF5ZXIuY29tLw==";

	public KSetting(Activity activity) {

	}

	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager conn = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (conn != null) {
				NetworkInfo[] info = conn.getAllNetworkInfo();
				if (info != null) {
					for (int i = 0; i < info.length; i++) {
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}















