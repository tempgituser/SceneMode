package com.example.scenemode;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class RegisterService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String PACKAGE_NAME = "com.example.scenemode.RegisterService";

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);

		Log.wtf("zzz", "on register!");
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_TIME_TICK);
		filter.addAction(Intent.ACTION_TIME_CHANGED);
		BootReceiver br = new BootReceiver();
		getApplicationContext().registerReceiver(br, filter);

		SetUtil.check(this);
		
	}
}
