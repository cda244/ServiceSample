package com.cda244.sample.servicesample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;


public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Bundle bundle = intent.getExtras();
		String message = bundle.getString("message");

		Time now = new Time();
		now.setToNow();

		Log.d("cda244", "receive " + now.second);
		((MainActivity) context).fromReceiver( message );
	}

}