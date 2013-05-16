package com.ckt.coffer;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


import android.content.Context;
import android.os.Environment;

public abstract class Objects implements ObjectInterface{
	private static final String DIR_NAME = "coffer";
	protected User mOwner;
	//note this object
	protected String mNameLable;
	protected String mUpdateTime;
	protected String mFilePath;
	protected Map<String,URI> mSyncUris;
	
	public Objects(Context context, User owner, String nameLable){
		mOwner = owner;
		mNameLable = nameLable;
		String sdpath = Environment.getExternalStorageDirectory().getPath();
		mFilePath = sdpath + "/" + DIR_NAME + "/" + mNameLable;
		mSyncUris = new HashMap<String, URI>();
	}

}
