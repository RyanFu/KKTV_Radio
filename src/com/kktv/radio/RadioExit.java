package com.kktv.radio;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class RadioExit extends Application {
	private List<Activity> mList = new LinkedList<Activity>();
	private static RadioExit instance;
	public static boolean isExit = false;

	private RadioExit() {

	}

	// 获取实例
	public synchronized static RadioExit getInstance() {
		if (instance == null) {
			instance = new RadioExit();
		}
		return instance;
	}

	// add activity
	public void addActivity(Activity activity) {
		mList.add(activity);
	}

	public Activity getTopActivity() {
		int topList = mList.size();
		return mList.get(topList - 1);
	}

	// 退出局部时调用
	public void exit() {
		try {
			isExit = true;
			for (Activity activity : mList) {
				if (activity != null) {
					activity.finish();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	// 当整个程序退出时调用，system.exit(0)，但是有时会重启
	public void exit_All() {
		try {
			isExit = true;
			for (Activity activity : mList) {
				if (activity != null) {
					activity.finish();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	// 当内存低时，自动gc释放内存
	@Override
	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}

}
