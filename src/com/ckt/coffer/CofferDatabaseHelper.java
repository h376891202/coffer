package com.ckt.coffer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.ckt.coffer.CofferConstruct.*;

public class CofferDatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "coffer.db";
	static final int DATABASE_VERSION = 100;
	static CofferDatabaseHelper sSingleSelfHelper;
	
	public static CofferDatabaseHelper getInstance(Context context){
		if ( sSingleSelfHelper == null){
			sSingleSelfHelper = new CofferDatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		return sSingleSelfHelper;
	}
	public CofferDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//create Table object
		db.execSQL("CREATE TABLE " + Tables.OBJECT + " (" +
				ObjectColumn.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
				ObjectColumn.COLUMN_CHANGE_TIME + " TEXT NOT NULL, " +
				ObjectColumn.COLUME_SYNC1 + " TEXT, " +
				ObjectColumn.COLUME_SYNC2 + " TEXT, " +
				ObjectColumn.COLUME_SYNC3 + " TEXT, " +
				ObjectColumn.COLUME_SYNC4 + " TEXT, " +
				ObjectColumn.COLUME_SYNC5 + " TEXT, " +
				ObjectColumn.COLUME_OWNER + " INTEGER NOT NULL, " +
				ObjectColumn.COLUMN_OBJECT_TYPE + " TEXT NOT NULL, " +
				" FOREIGN KEY("+ObjectColumn.COLUME_OWNER+" ) REFERENCES "+
				Tables.USER + " (" + UserColume.COLUMN_ID + " ));");
		
		//create table mimetypes
		db.execSQL("CREATE TABLE " + Tables.MIMETYPE + " ( " +
				MimeTypeColumn.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				MimeTypeColumn.COLUMN_MIME_TYPE + " TEXT NOT NULL);");
		
		//create tale users
		db.execSQL("CREATE TABLE " + Tables.USER + " (" +
				UserColume.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				UserColume.COLUMN_NAME + " TEXT NOT NULL, "+
				UserColume.COLUME_PASSWORD + " TEXT NOT NULL );");
		
		//create table data
		db.execSQL("CREATE TABLE " + Tables.DATA + "(" +
				DataColume.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				DataColume.DATA1 + " TEXT, " +
				DataColume.DATA2 + " TEXT, " +
				DataColume.DATA3 + " TEXT, " +
				DataColume.DATA4 + " TEXT, " +
				DataColume.DATA5 + " TEXT, " +
				DataColume.DATA6 + " TEXT, " +
				DataColume.DATA7 + " TEXT, " +
				DataColume.DATA8 + " TEXT, " +
				DataColume.DATA9 + " TEXT, " +
				DataColume.DATA10 + " TEXT, " +
				DataColume.DATA11 + " TEXT, " +
				DataColume.DATA12 + " TEXT, " +
				DataColume.DATA13 + " TEXT, " +
				DataColume.DATA14 + " TEXT, " +
				DataColume.DATA15 + " TEXT, " +
				DataColume.MIME_TYPE_ID + " INTEGER NOT NULL, " +
				DataColume.Object_ID + " INTEGER NOT NULL, " +
				" FOREIGN KEY ("+DataColume.MIME_TYPE_ID+") REFERENCES " +
				Tables.MIMETYPE + "(" + MimeTypeColumn.COLUMN_ID + ")," +
				" FOREIGN KEY ("+DataColume.Object_ID+") REFERENCES " + 
				Tables.OBJECT + "(" + ObjectColumn.COLUMN_ID + "));");
		
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	

}
