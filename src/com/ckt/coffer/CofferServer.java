package com.ckt.coffer;

import java.util.ArrayList;
import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CofferServer extends Service implements ObjectInterface{
	private List<Objects> mObjects = new ArrayList<Objects>();
	
	public CofferServerBinder mCofferServiceBinder = new CofferServerBinder();
	
	public class CofferServerBinder extends Binder{
		 public CofferServer getService(){
	            return CofferServer.this;
	        }
	};
	
	public void registObjects(Objects objects){
		mObjects.add(objects);
	}
	
	public void unRegistObjects(Objects objects){
		mObjects.remove(objects);
	}
	
	public void unRegistObjects(String objectsName){
		for(Objects object : mObjects){
			if(object.mNameLable != null && object.mNameLable.equals(objectsName)){
				mObjects.remove(object);
			}
		}
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}
	
	@Override
	public void syncToTarget() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fileToTarget() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncToFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncToCoffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mCofferServiceBinder;
	}

}
