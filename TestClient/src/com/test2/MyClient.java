package com.test2;

import java.net.*;
import java.io.*;
import java.util.*;

import com.common.*;

public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient mc = new MyClient();
	}
	
	public MyClient(){
		
		try {
			
			Socket s = new Socket("127.0.0.1",4567);
			
			//¶ÔÏóÁ÷
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			
			User u = new User();
			//u.setName("zwb");
			u.setName("zwb");
			u.setPass("123456");			
			oos.writeObject(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
