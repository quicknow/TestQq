package com.qq.server.model;
import java.net.*;
import java.io.*;
import java.util.*;
import com.qq.common.*;

public class MyServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyServer ms = new MyServer();
	}
	
	
	public MyServer(){
		try {
			ServerSocket ss = new ServerSocket(9999); //服务器端监听9999端口
			
			while(true){
				Socket s = ss.accept();	//阻断等待连接				
				//接受客户端发来的信息
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User)ois.readObject();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				Message m = new Message();
				
				//如果密码是123456则正常登陆，否则提示错误
				if(u.getPass().equals("123456")){					
					m.setMesType("1");
					oos.writeObject(m);
				}else {
					m.setMesType("2");
					oos.writeObject(m);
					//密码错误，关闭本次连接   以便 继续一次新的循环监听
					s.close();
				}
				
				
			}	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
