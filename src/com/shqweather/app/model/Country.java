package com.shqweather.app.model;

public class Country {
	int id;
	int cid;
	String name;
	String code;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getCid(){
		return cid;
	}
	public void setCid(int cid){
		this.cid=cid;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code=code;
	}
}
