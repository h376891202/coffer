package com.ckt.coffer;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.ckt.coffer.CofferConstruct.Tables;

public class CofferProvider extends ContentProvider{
	
	private static final int OBJECTS = 1000;
	private static final int DATA = 1001;
	private static final int USERS = 1002;
	private static final int MIMETYPES = 1003;
	private static final String AUTHORITY  = "com.ckt.coffer";
	
	private static UriMatcher sMatcher =  new UriMatcher(UriMatcher.NO_MATCH);
	static{
		sMatcher.addURI(AUTHORITY, Tables.OBJECT, OBJECTS);
		sMatcher.addURI(AUTHORITY, Tables.DATA, DATA);
		sMatcher.addURI(AUTHORITY, Tables.USER, USERS);
		sMatcher.addURI(AUTHORITY, Tables.MIMETYPE, MIMETYPES);
	}
	
	private CofferDatabaseHelper mDatabaseHelper;
	private Context mContext;
	

	
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean onCreate() {
		mContext = getContext();
		mDatabaseHelper = CofferDatabaseHelper.getInstance(mContext);
		mDatabaseHelper.getWritableDatabase();
		return true;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/********************************************************************
	 *  The below code is useless, Didn't implements. 
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		//Do nothing... didn't provide
		return 0;
	}
	@Override
	public String getType(Uri uri) {
		//Do nothing... didn't provide
		return null;
	}
}
