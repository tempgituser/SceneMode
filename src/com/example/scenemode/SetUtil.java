package com.example.scenemode;

import android.content.Context;
import android.media.AudioManager;

public class SetUtil {
	
	public static void check(Context t){
		boolean isOpen = DataUtil.getOpenStatus(t) > 0;
		
		if (!isOpen) {
			return;
		}
		
		if (DataUtil.getNowMode(t) != DataUtil.getModeTodo()){
			SetUtil.setMode(t, DataUtil.getModeTodo());
		}
	}

	public static void setMode(Context t, int mode){
		if(mode == DataUtil.getNowMode(t)){
			return;
		}
//		if(getRingerModeNormal(t) == A){
//			
//		}
		// goto set!!!!
		if (mode == DataUtil.NOISE) {
			int volume = SetUtil.getRingtoneVolume(t);
			DataUtil.setNormalVolume(t, volume);
			
			AudioManager mAudioManager = (AudioManager) t
					.getSystemService(Context.AUDIO_SERVICE);
			int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
			mAudioManager.setStreamVolume(AudioManager.STREAM_RING, maxVolume, 0);
			DataUtil.setNowMode(t, mode);
		
		} else if (mode == DataUtil.NORMAL) {
			revertVolumeAndMode(t);
		}
		
	}
	
	public static void revertVolumeAndMode(Context t){
		int volume = DataUtil.getNormalVolume(t);
		AudioManager mAudioManager = (AudioManager) t
				.getSystemService(Context.AUDIO_SERVICE);
		mAudioManager.setStreamVolume(AudioManager.STREAM_RING, volume, 0);
		DataUtil.setNowMode(t, DataUtil.NORMAL);
	}
	
	
//
//	static int normalVolume;
//	
//	public static int getVolume(Context context) {
//		AudioManager mAudioManager = (AudioManager) context
//				.getSystemService(Context.AUDIO_SERVICE);
//		int current = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//		Log.d("zzz", "getVolume current : " + current);
//		return current;
//	}
//
//	public static void setVolume(Context context, int current) {
//		AudioManager mAudioManager = (AudioManager) context
//				.getSystemService(Context.AUDIO_SERVICE);
//		mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, current, 0);
//		Log.d("zzz", "setVolume current : " + current);
//	}
//
//	public static void setVolumeToNormal(Context context) {
//		AudioManager mAudioManager = (AudioManager) context
//				.getSystemService(Context.AUDIO_SERVICE);
//		mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, normalVolume,
//				0);
//		Log.d("zzz", "setVolumeToNormal current : " + normalVolume);
//	}
//
//	public static void setMaxVolume(Context context) {
//		AudioManager mAudioManager = (AudioManager) context
//				.getSystemService(Context.AUDIO_SERVICE);
//		int max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//		mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, max, 0);
//		Log.d("zzz", "setMaxVolume, max : " + max);
//	}
//	
//	/**
//	 * 铃声：静音模式
//	 */
//	public static void setRingerModeSilent(Context t) {
//		AudioManager volMgr = (AudioManager) t
//				.getSystemService(Context.AUDIO_SERVICE);
//		volMgr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
//	}
//
//	/**
//	 * 铃声：振动模式
//	 */
//	public static void setRingerModeVibrate(Context t) {
//		AudioManager volMgr = (AudioManager) t
//				.getSystemService(Context.AUDIO_SERVICE);
//		volMgr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
//	}
//
//	/**
//	 * 铃声：通常模式
//	 */
//	public static void setRingerModeNormal(Context t) {
//		AudioManager volMgr = (AudioManager) t
//				.getSystemService(Context.AUDIO_SERVICE);
//		volMgr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
//	}
//
//	/**
//	 * 获得铃声模式
//	 * 
//	 * @return AudioManager.RINGER_MODE_NORMAL
//	 * @return AudioManager.RINGER_MODE_VIBRATE
//	 * @return AudioManager.RINGER_MODE_SILENT
//	 */
//	public static int getRingerModeNormal(Context t) {
//		AudioManager volMgr = (AudioManager) t
//				.getSystemService(Context.AUDIO_SERVICE);
//		return volMgr.getRingerMode();
//	}
//
	/**
	 * 得到铃声音量
	 */
	public static int getRingtoneVolume(Context t) {
		AudioManager mAudioManager = (AudioManager) t
				.getSystemService(Context.AUDIO_SERVICE);
		int volume = mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
//		int volume2 = mAudioManager.getStreamVolume(AudioManager.STREAM_ALARM);
//		int volume3 = mAudioManager.getStreamVolume(AudioManager.STREAM_DTMF);
//		int volume4 = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//		int volume5 = mAudioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
//		int volume6 = mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
//		int volume7 = mAudioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
		return volume;
	}
	/**
	 * 得到铃声音量（百分比）
	 */
	public static int getRingtoneVolumePercent(Context t) {
		AudioManager mAudioManager = (AudioManager) t
				.getSystemService(Context.AUDIO_SERVICE);
		int volume = mAudioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
		return volume * 100
				/ mAudioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
	}
//
//	/**
//	 * 得到通话音量（百分比）
//	 */
//	public static int getPhoneTalkVolume(Context t) {
//		AudioManager mAudioManager = (AudioManager) t
//				.getSystemService(Context.AUDIO_SERVICE);
//		int volume = mAudioManager
//				.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
//		return volume;
////		return volume
////				* 100
////				/ mAudioManager
////						.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);
//	}

}
