package com.qq.common;

//实现序列化接口 约定由三种message:1 登陆成功 2：登陆失败  3：发送的聊天内容
public class Message implements java.io.Serializable{
	private String mesType;

	public String getMesType() {
		return mesType;
	}

	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
	
	
}
