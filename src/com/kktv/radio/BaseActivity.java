package com.kktv.radio;

import java.util.Timer;
import java.util.TimerTask;

import com.kktv.radio.util.AppLog;
import com.kktv.radio.util.KSetting;

import it.sauronsoftware.base64.Base64;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class BaseActivity extends Activity {

	private float scale;
	public ProgressDialog progressDialog;
	public static String radioUrl;
	public static String radioUrlHead;
	private boolean isBack = false;
	private Timer BackTimer = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		radioUrl = Base64.decode(KSetting.radioURL);
		radioUrlHead = Base64.decode(KSetting.radioURLHead);
	}

	public void init() {
		AppLog.enableLogging(true);
		progressDialog = new ProgressDialog(this);
		progressDialog.setMessage(getResources().getText(R.string.raido_parse_dialog_text));
		progressDialog.setCancelable(false);
		scale = getResources().getDisplayMetrics().density;
	}

	public int dip2px(float dpValue) {
		return (int) (dpValue * scale + 0.5f);
	}

	public void showInfo(int id) {
		Toast toast = Toast.makeText(this, id, Toast.LENGTH_LONG);
		toast.show();
	}

	public void showInfo(String text) {
		Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
		toast.show();
	}

	public void exitKKRaido(){
		RadioExit.getInstance().exit();
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (!isBack) {
				isBack = true;
				showInfo(R.string.click_again_to_exit_the_program);
				BackTimer = new Timer();
				BackTimer.schedule(new backTimerTask(), 1000);
			} else {
				exitKKRaido();
			}
		}
		return true;
	}

	// 定时双击back
	class backTimerTask extends TimerTask {
		@Override
		public void run() {
			isBack = false;
		}
	}
}
