package com.example.scenemode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context t, Intent intent) {

		String action = intent.getAction();
		 
		if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
//			IntentFilter filter = new IntentFilter();
//			filter.addAction(Intent.ACTION_TIME_TICK);
//			filter.addAction(Intent.ACTION_TIME_CHANGED);
//			t.registerReceiver(this, filter);
			Log.wtf("zzz", "on boot!");
//			Vibrator vib = (Vibrator) t.getSystemService(Service.VIBRATOR_SERVICE);
//	        vib.vibrate(500);
	        
	        
			Intent intent1 = new Intent(RegisterService.PACKAGE_NAME);
			intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			t.startService(intent1);
        }  

		if (action.equals(Intent.ACTION_SHUTDOWN)) {  
			SetUtil.revertVolumeAndMode(t);
        }  

		if (action.equals(Intent.ACTION_TIME_TICK)) {

//			Log.wtf("zzz", "on ACTION_TIME_TICK!");
//			Vibrator vib = (Vibrator) t.getSystemService(Service.VIBRATOR_SERVICE);
//	        vib.vibrate(100);
			SetUtil.check(t);
		}
		
	}

	
	
	
	
	
}
