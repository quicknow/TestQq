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
			ServerSocket ss = new ServerSocket(9999); //�������˼���9999�˿�
			
			while(true){
				Socket s = ss.accept();	//��ϵȴ�����				
				//���ܿͻ��˷�������Ϣ
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User)ois.readObject();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				Message m = new Message();
				
				//���������123456��������½��������ʾ����
				if(u.getPass().equals("123456")){					
					m.setMesType("1");
					oos.writeObject(m);
				}else {
					m.setMesType("2");
					oos.writeObject(m);
					//������󣬹رձ�������   �Ա� ����һ���µ�ѭ������
					s.close();
				}
				
				
			}	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
