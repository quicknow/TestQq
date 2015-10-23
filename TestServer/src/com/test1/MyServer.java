package com.test1;
import java.net.*;
import java.io.*;
import java.util.*;

import com.common.*;

public class MyServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer ms = new MyServer();
	}
	
	public MyServer(){
		
try {
			
			ServerSocket ss = new ServerSocket(4567);
			Socket s = ss.accept();
			
			ObjectInputStream ois= new ObjectInputStream(s.getInputStream());
			User u = (User)(ois.readObject());
			
			System.out.println("name:"+u.getName()+"pass"+u.getPass());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
