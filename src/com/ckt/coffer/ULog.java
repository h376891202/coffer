package com.ckt.coffer;

import android.util.Log;

public final class ULog {
	//TODO When develop finish , must set this value to 25.
	private static final int LOG_LEVEL = 10;
	private static final boolean LOG_E_ENABLE = LOG_LEVEL >= 10;
	private static final boolean LOG_W_ENABLE = LOG_LEVEL >= 20;
	private static final boolean LOG_V_ENABLE = LOG_LEVEL >= 30;
	private static final boolean LOG_D_ENABLE = LOG_LEVEL >= 40;
	
	public static void logE(String tag,String message){
		if(LOG_E_ENABLE){
			Log.e(tag, message);
		}
	}
	
	public static void logW(String tag,String message){
		if(LOG_W_ENABLE){
			Log.w(tag, message);
		}
	}
	
	public static void logV(String tag,String message){
		if(LOG_V_ENABLE){
			Log.v(tag, message);
		}
	}
	
	public static void logD(String tag,String message){
		if(LOG_D_ENABLE){
			Log.d(tag, message);
		}
	}
}
