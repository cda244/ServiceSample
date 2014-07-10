package com.cda244.sample.servicesample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;


public class MyService extends Service {

	private static boolean isRun;
	private Time mTime;
	private Timer mTimer;

	@Override
	public void onCreate() {
		mTime = new Time();
		mTime.setToNow();
		Log.d("cda244", "サービス onCreate "+ mTime.second );

		if( !isRun ){
			isRun = true;
			doSomething();
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//明示的にサービスの起動、停止が決められる場合の返り値
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		isRun=false;

		mTime.setToNow();
		Log.d("cda244", "サービス onDestroy "+ mTime.second );

		if(mTimer != null ){
			mTimer.cancel();
			mTimer = null;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}


	private void doSomething()
	{
		if( mTimer != null ){
			mTimer.cancel();
		}

		mTimer = new Timer();
		TimerTask timerTask = new TimerTask() {
			public void run() {
				mTime.setToNow();
				Log.d("cda244", "サービス do "+ mTime.second );

				Intent i = new Intent();
				i.putExtra("message", "Hello, BroadCast!");
				i.setAction("MY_ACTION");
				getBaseContext().sendBroadcast(i);
			}
		};
		mTimer.schedule(timerTask, 1000, 1000);
	}


}