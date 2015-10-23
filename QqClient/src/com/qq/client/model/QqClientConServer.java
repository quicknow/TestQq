package com.qq.client.model;
import java.util.*;
import java.io.*;
import java.net.*;
import com.qq.common.*;



public class QqClientConServer {

	
	public boolean sendLogininfo(Object o){
		boolean b = false;
		try {
			
			Socket s = new Socket("127.0.0.1",9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());			
			oos.writeObject(o);  //发送给服务端
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms =(Message)ois.readObject(); //读取服务端发送的数据
			
			//根据服务器发送过来的报的type类型确定登陆是否成功
			if(ms.getMesType().equals("1")){
				b=true;
				
			}else {
				b=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			
		}
		
		return b;
	}
		
	
	
	
	
	public void sendInfoToServer(Object o){
		
	}
}
