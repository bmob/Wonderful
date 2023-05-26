package com.xgr.wonderful.ui;

import android.os.Bundle;
import android.os.Handler;

import com.xgr.wonderful.R;
import com.xgr.wonderful.ui.base.BaseActivity;
import com.xgr.wonderful.utils.Constant;
import com.xgr.wonderful.utils.LogUtils;

import cn.bmob.v3.Bmob;

/**
 * @author kingofglory
 *         email: kingofglory@yeah.net
 *         blog:  http:www.google.com
 * @date 2014-2-21
 * TODO 闪屏界面，根据指定时间进行跳转
 * 		在activity_splash.xml中加入background属性并传入图片资源ID即可
 */
public class SplashActivity extends BaseActivity {

	private static final long DELAY_TIME = 2000L;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//Bmob SDK初始化--只需要这一段代码即可完成初始化
				//请到Bmob官网(http://www.bmob.cn/)申请ApplicationId,具体地址:http://docs.bmob.cn/android/faststart/index.html?menukey=fast_start&key=start_android
		Bmob.initialize(this, Constant.BMOB_APP_ID);
		
		LogUtils.i(TAG,TAG + " Launched ！");
//		MobclickAgent.openActivityDurationTrack(UmengStat.IS_OPEN_ACTIVITY_AUTO_STAT);
//		FeedbackAgent agent = new FeedbackAgent(this);
//		agent.sync();
		redirectByTime();		
//		if(sputil.getValue("isPushOn", true)){
//			PushAgent mPushAgent = PushAgent.getInstance(mContext);
//			mPushAgent.enable();
//			LogUtils.i(TAG,"device_token:"+UmengRegistrar.getRegistrationId(mContext));
//		}else{
//			PushAgent mPushAgent = PushAgent.getInstance(mContext);
//			mPushAgent.disable();
//		}
		
	}
	
	/**
	 * 根据时间进行页面跳转
	 */
	private void redirectByTime() {
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				redictToActivity(SplashActivity.this, MainActivity.class, null);
				finish();
			}
		}, DELAY_TIME);
	}

}
