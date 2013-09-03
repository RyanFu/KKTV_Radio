package com.kktv.radio;

import com.kktv.radio.util.AppLog;
import com.kktv.radio.util.KSetting;

import it.sauronsoftware.base64.Base64;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class BaseActivity extends Activity{
	
	private float scale;
	public ProgressDialog progressDialog;
	public static String radioUrl;
	public static String radioUrlHead;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		radioUrl = Base64.decode(KSetting.radioURL);
		radioUrlHead = Base64.decode(KSetting.radioURLHead);
	}

	
	public void init(){
		AppLog.enableLogging(true);
		progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("解析中...");
		progressDialog.setCancelable(false);
		scale = getResources().getDisplayMetrics().density;
	}

	public int dip2px(float dpValue) {
		return (int) (dpValue * scale + 0.5f);
	}
}
