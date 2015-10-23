package com.qq.server.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.qq.server.model.*;
public class MyServerFrame extends JFrame implements ActionListener{
	JPanel jp = null;
	JButton jb,jb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServerFrame ms = new MyServerFrame();
	}
	
	public MyServerFrame(){
		jp = new JPanel();
		jb = new JButton("启动服务器");
		jb.addActionListener(this);
		jb2= new JButton("关闭服务器");
		
		jp.add(jb);
		jp.add(jb2);
		this.add(jp,"North");
		this.setVisible(true);
		this.setSize(400,300);
		this.setLocation(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			new MyServer();
		}
	}

}
