/**
 * 
 */
package com.shqweather.app.model;

import java.util.ArrayList;
import java.util.List;

import com.shqweather.app.db.MyHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author SHQ
 *
 */
public class SHQDB {

	SQLiteDatabase db;
	static SHQDB shq;
	public static final String NAME="shq.db";
	public static final int VERSION=1;
	private SHQDB(Context con){
		MyHelper help=new MyHelper(con, NAME, null, VERSION);
		db=help.getWritableDatabase();
		
	}
	
	public synchronized static SHQDB getInstance(Context con){
		if(shq==null){
			shq=new SHQDB(con);
		}
		return shq;
	}
	
	public void saveProvince(Province p){
		ContentValues con=new ContentValues();
		con.put("id", p.getId());
		con.put("province_name", p.getName());
		con.put("province_code", p.getCode());
		db.insert("Province", null, con);
		
		}
	public List<Province> loadProvince(){
		List<Province> list=new ArrayList<Province>();
		Cursor cursor=db.query("Province", null,null, null,null,null,null);
		if(cursor.moveToFirst()){
			do{
				Province p=new Province();
				p.setId(cursor.getInt(cursor.getColumnIndex("id")));
				p.setName(cursor.getString(cursor.getColumnIndex("province_name")));
				p.setCode(cursor.getString(cursor.getColumnIndex("province_code")));
				list.add(p);
			}
			while(cursor.moveToNext());
			 
			
		}
		return list;
		
		
	}
	public void saveCity(City c){
		ContentValues con=new ContentValues();
		con.put("id", c.getId());
		con.put("city_name", c.getName());
		con.put("city_code", c.getCode());
		con.put("province_id", c.getPid());
		db.insert("Province", null, con);
		
		}
	public List<City> loadCity(int pid){
		List<City> list=new ArrayList<City>();
		Cursor cursor=db.query("City", null,"province_id=",new String[]{String.valueOf(pid)},null,null,null);
		if(cursor.moveToFirst()){
			do{
				City c=new City();
				c.setId(cursor.getInt(cursor.getColumnIndex("id")));
				c.setName(cursor.getString(cursor.getColumnIndex("city_name")));
				c.setCode(cursor.getString(cursor.getColumnIndex("city_code")));
				c.setPid(cursor.getInt(cursor.getColumnIndex("province_id")));
				list.add(c);
			}
			while(cursor.moveToNext());
			 
			
		}
		return list;
		
		
	}
	public void saveCountry(Country c){
		ContentValues con=new ContentValues();
		con.put("id", c.getId());
		con.put("country_name", c.getName());
		con.put("country_code", c.getCode());
		con.put("city_id", c.getCid());
		db.insert("Country", null, con);
		
		}
	public List<Country> loadCountry(int cid){
		List<Country> list=new ArrayList<Country>();
		Cursor cursor=db.query("Country", null,"city_id=",new String[]{String.valueOf(cid)},null,null,null);
		if(cursor.moveToFirst()){
			do{
				Country c=new Country();
				c.setId(cursor.getInt(cursor.getColumnIndex("id")));
				c.setName(cursor.getString(cursor.getColumnIndex("country_name")));
				c.setCode(cursor.getString(cursor.getColumnIndex("country_code")));
				c.setCid(cursor.getInt(cursor.getColumnIndex("city_id")));
				list.add(c);
			}
			while(cursor.moveToNext());
			 
			
		}
		return list;
		
		
	}
}
