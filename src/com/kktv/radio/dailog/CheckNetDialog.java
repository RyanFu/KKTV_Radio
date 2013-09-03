package com.kktv.radio.dailog;

import com.kktv.radio.RadioExit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;


public class CheckNetDialog {

	public Context context;
	public CheckNetDialog(Context context){
		this.context = context;
	}
	
	public void showNoNet(){
		new AlertDialog.Builder(context)
			.setTitle("网络不可用")
			.setMessage("选择退出，或者跳转到网络选择界面")
			.setPositiveButton("退出", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					RadioExit.getInstance().exit();
				}
			})
			.setNegativeButton("设置网络", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
		            context.startActivity(intent);
				}
			})
			.show();
	}
}
