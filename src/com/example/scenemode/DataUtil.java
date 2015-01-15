package com.example.scenemode;

import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class DataUtil {

	public static void setOpenStatus(Context t, int open) {
		Editor e = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS).edit();
		e.putInt("open", open);
		e.commit();
	}

	public static int getOpenStatus(Context t) {
		SharedPreferences sharedata = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS);
		int open = sharedata.getInt("open", 0);
		return open;
	}
	

	public static void setVolume(Context t, int volume) {
		Editor e = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS).edit();
		e.putInt("volume", volume);
		e.commit();
	}

	public static int getVolume(Context t) {
		SharedPreferences sharedata = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS);
		int open = sharedata.getInt("volume", SetUtil.getRingtoneVolume(t));
		return open;
	}
	
	public static int getModeTodo(){

		Calendar c = Calendar.getInstance();
		int week = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		// 休息日
		if(week == Calendar.SATURDAY || week == Calendar.SUNDAY){
			if(10<=hour && hour<=22){
				return NOISE;
			}
			else{
				return NORMAL;
			}
		}
		
		// 工作日
		// 0到7点
		if ((hour >= 0 && hour < 7)) {
			//normal
			return NOISE;
		}
		if ((hour == 7 && minute > 30) || (hour == 8 && minute <= 30) || (hour == 17 && minute > 45) || (hour >= 18 && hour <= 22)) {
			// noise
			return NOISE;
		}
		return NORMAL;
	}
	public static int NORMAL = 0;
	public static int NOISE = 1;
	public static int MUTE = 2;
	

	public static void setNowMode(Context t, int mode) {
		Editor e = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS).edit();
		e.putInt("mode", mode);
		e.commit();
	}

	public static int getNowMode(Context t) {
		SharedPreferences sharedata = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS);
		int open = sharedata.getInt("mode", NORMAL);
		return open;
	}
	
	public static void setNormalVolume(Context t, int volume) {
		Editor e = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS).edit();
		e.putInt("volume", volume);
		e.commit();
	}

	public static int getNormalVolume(Context t) {
		SharedPreferences sharedata = t.getSharedPreferences("data", Context.MODE_MULTI_PROCESS);
		int open = sharedata.getInt("volume", NORMAL);
		return open;
	}
}
