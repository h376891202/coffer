package com.ckt.coffer;

import java.util.Set;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.ckt.coffer.CofferConstruct.Tables;

public class CofferProvider extends ContentProvider{
	private static final String TAG = "CofferProvider";
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
		Uri retUri = null;
		SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
		
		try {
			int march = sMatcher.match(uri);
			Set<String> keys = values.keySet();
			ULog.logV(TAG, "begin insert ..  march table is "+ march);
			
			//check the contentvalues is null or not.
			if(keys.size() == 0){
				ULog.logW(TAG, "Have no value to insert ,abort!!");
				return null;
			}else{
				for(String key : keys){
					ULog.logD(TAG, "Insert Key=" + key + "values=" + values.getAsString(key));
				}
			}
			
			long retId = -1;
			switch (march) {
			case OBJECTS:
				retId = db.insert(Tables.OBJECT, null, values);
				break;
			case DATA:
				retId = db.insert(Tables.DATA, null, values);
				break;
			case USERS:
				retId = db.insert(Tables.USER, null, values);
				break;
			case MIMETYPES:
				retId = db.insert(Tables.MIMETYPE, null, values);
				break;

			default:
				ULog.logE(TAG, "insert Uri march error!!");
				return null;
			}
			
			
			if(retId != -1){
				retUri = ContentUris.withAppendedId(uri, retId);
			}
			db.setTransactionSuccessful();
		} catch (Exception e) {
			ULog.logE(TAG, "insert Error! " + e.getMessage());
			db.endTransaction();
		}
		ULog.logV(TAG, "insert end uri = " + retUri.toString());
		return retUri;
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int march = sMatcher.match(uri);
		int retResult = -1;
		SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
		
		ULog.logV(TAG, "begin delete ..  march table is "+ march);
		switch (march) {
		case OBJECTS:
			retResult = db.delete(Tables.OBJECT, selection, selectionArgs);
			break;
		case DATA:
			retResult = db.delete(Tables.DATA, selection, selectionArgs);
			break;
		case USERS:
			retResult = db.delete(Tables.USER, selection, selectionArgs);
			break;
		case MIMETYPES:
			retResult = db.delete(Tables.MIMETYPE, selection, selectionArgs);
			break;

		default:
			ULog.logE(TAG, "delete Uri march error!!");
			return -1;
		}
		ULog.logV(TAG, "end delete .. result = "+ retResult);
		return retResult;
	}

	@Override
	public boolean onCreate() {
		mContext = getContext();
		mDatabaseHelper = CofferDatabaseHelper.getInstance(mContext);
		return true;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		int march = sMatcher.match(uri);
		Cursor retCursor = null;
		SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
		
		ULog.logV(TAG, "start query .. march = "+ march);
		switch (march) {
		case OBJECTS:
			//TODO Query columns.
			retCursor = db.query(Tables.OBJECT, null, selection, selectionArgs, null, null, null);
			break;
		case DATA:
			retCursor = db.query(Tables.DATA, null, selection, selectionArgs, null, null, null);
			break;
		case USERS:
			retCursor = db.query(Tables.USER, null, selection, selectionArgs, null, null, null);
			break;
		case MIMETYPES:
			retCursor = db.query(Tables.MIMETYPE, null, selection, selectionArgs, null, null, null);
			break;

		default:
			ULog.logE(TAG, "delete Uri march error!!");
			return null;
		}
		ULog.logV(TAG, "end query ..");
		return retCursor;
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
