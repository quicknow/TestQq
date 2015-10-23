/*
 * QQ聊天界面
 */
package com.qq.client.view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class QqChat extends JFrame{
	JTextArea jta=null;
	JTextField jtf =null;
	JButton jb=null;
	JPanel jp = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqChat qc= new QqChat("zwb","1");
	}
	
	public QqChat(String ownno,String frendno){
		jta=new JTextArea();
		jtf=new JTextField(20);
		jb=new JButton("发送");
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta);
		this.add(jp,"South");
		this.setVisible(true);
		this.setSize(400,300);
		this.setTitle(ownno+"正在和"+frendno+"聊天");
		this.setIconImage((new ImageIcon("images/qq.jpg")).getImage());
		this.setLocation(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
