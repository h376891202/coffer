package com.ckt.coffer;

import java.net.URI;

public class CofferConstruct {
	public static final String AUTHORITY  = "com.ckt.coffer";
	public static final URI OBJECT_URI = URI.create(AUTHORITY+"/"+Tables.OBJECT);
	public static final URI MIME_URI = URI.create(AUTHORITY+"/"+Tables.MIMETYPE);
	public static final URI USER_URI = URI.create(AUTHORITY+"/"+Tables.USER);
	public static final URI DATA_URI = URI.create(AUTHORITY+"/"+Tables.DATA);
	
	class Tables{
		public static final String OBJECT = "object";
		public static final String MIMETYPE = "mimetypes";
		public static final String USER = "users";
		public static final String DATA = "DATA";
	}
	
	class ObjectColumn{
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_CHANGE_TIME = "change_time";
		public static final String COLUMN_OBJECT_TYPE = "object_type";
		public static final String COLUME_OWNER = "owner_id";
		public static final String COLUME_SYNC1 = "sync1";
		public static final String COLUME_SYNC2 = "sync2";
		public static final String COLUME_SYNC3 = "sync3";
		public static final String COLUME_SYNC4 = "sync4";
		public static final String COLUME_SYNC5 = "sync5";
	}
	
	class MimeTypeColumn{
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_MIME_TYPE = "mime_type";
	}
	
	class UserColume{
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_NAME = "name";
		public static final String COLUME_PASSWORD = "password";
	}
	
	class DataColume{
		public static final String COLUMN_ID = "_id";
		public static final String MIME_TYPE_ID = "mime_type_id";
		public static final String Object_ID = "object_id";
		public static final String DATA1 = "data1";
		public static final String DATA2 = "data2";
		public static final String DATA3 = "data3";
		public static final String DATA4 = "data4";
		public static final String DATA5 = "data5";
		public static final String DATA6 = "data6";
		public static final String DATA7 = "data7";
		public static final String DATA8 = "data8";
		public static final String DATA9 = "data9";
		public static final String DATA10 = "data10";
		public static final String DATA11 = "data11";
		public static final String DATA12 = "data12";
		public static final String DATA13 = "data13";
		public static final String DATA14 = "data14";
		public static final String DATA15 = "data15"; 
	}
}
