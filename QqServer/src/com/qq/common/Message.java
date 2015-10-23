package com.qq.common;

//实现序列化接口
public class Message implements java.io.Serializable{
	private String mesType;

	public String getMesType() {
		return mesType;
	}

	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
	
	
}
