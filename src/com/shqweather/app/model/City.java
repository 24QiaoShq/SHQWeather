package com.shqweather.app.model;

public class City {
	int id;
	int pid;
	String name;
	String code;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getPid(){
		return pid;
	}
	public void setPid(int pid){
		this.pid=pid;
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
