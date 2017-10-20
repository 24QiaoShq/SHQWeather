package com.shqweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

	public static final String PROVINCE="create table Province("
			+"id integer primary key autoincrement,"
			+"province_name text,"
			+"province_code text)";
	public static final String CITY="create table City("
			+"id integer primary key autoincrement,"
			+"city_name text,"
			+"province_id integer,"
			+"city_code text)";
	public static final String COUNTRY="create table Country("
			+"id integer primary key autoincrement,"
			+"country_name text,"
			+"city_id integer,"
			+"country_code text)";
	
	public MyHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(PROVINCE); 
		db.execSQL(CITY);
        db.execSQL(COUNTRY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO 自动生成的方法存根

	}

}
