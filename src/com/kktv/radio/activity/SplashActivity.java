package com.kktv.radio.activity;

import com.kktv.radio.R;
import com.kktv.radio.RadioExit;
import com.kktv.radio.dailog.CheckNetDialog;
import com.kktv.radio.util.AppLog;
import com.kktv.radio.util.KSetting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class SplashActivity extends Activity implements AnimationListener{
	private Animation animationIn;
	private Animation animationOut;
	private int animationStep = 0;
	private ImageView Splash_Logo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		RadioExit.getInstance().addActivity(this);
		AppLog.enableLogging(true);
		Splash_Logo = (ImageView)findViewById(R.id.splash_logo);
		loadAnimation();
		Splash_Logo.startAnimation(animationIn);
	}

	/**
	 * 加载动画特效
	 */
	private void loadAnimation(){
		animationIn = AnimationUtils.loadAnimation(this, R.anim.splash_in);
		animationOut = AnimationUtils.loadAnimation(this, R.anim.splash_out);
		animationIn.setAnimationListener(this);
		animationOut.setAnimationListener(this);
	}
	
	@Override
	public void onAnimationEnd(Animation arg0) {
		switch (animationStep) {
		case 0:
			animationStep++;
			Splash_Logo.startAnimation(animationOut);
			break;
		case 1:
			animationStep++;
			if (KSetting.isNetworkConnected(this)) {
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, KKTV_RADIO.class);
				startActivity(intent);
			}else {
				new CheckNetDialog(this).showNoNet();
			}
			break;
		}
	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		
	}

	@Override
	public void onAnimationStart(Animation arg0) {
		
	}
}
