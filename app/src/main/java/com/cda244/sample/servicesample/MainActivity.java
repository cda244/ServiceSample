package com.cda244.sample.servicesample;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {

	private MyReceiver mReceiver;
	private IntentFilter mIntentFilter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		if(mReceiver == null ) {
			mReceiver = new MyReceiver();
			mIntentFilter = new IntentFilter();
			mIntentFilter.addAction("MY_ACTION");

			registerReceiver(mReceiver, mIntentFilter);
		}
	}


	public void sStart() {
		startService(new Intent(this, MyService.class));
	}


	public void sStop() {
		stopService(new Intent(this, MyService.class));
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mReceiver);
	}

	public void fromReceiver(String message) {
		Log.d("cda244", "fromReceiver  " + message);
	}
}
