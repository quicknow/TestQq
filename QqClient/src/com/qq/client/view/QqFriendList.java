/*
 * QQ好友列表
 * 
 */
package com.qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QqFriendList extends JFrame implements ActionListener,MouseListener{
	//处理第一张卡片
	JPanel jp1,jp2,jp3=null;
	JButton jb1,jb2,jb3=null;
	JScrollPane jsp=null;
	
	//第二张卡片
	JPanel jpmsr1,jpmsr2,jpmsr3=null;
	JButton jbmsr1,jbmsr2,jbmsr3=null;
	JScrollPane jspmsr=null;

	//卡片布局
	CardLayout cl=null;
	
	String owenerId;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//QqFriendList qfl= new QqFriendList("zwb");
	}
	
	public QqFriendList(String owenerId){
		this.owenerId=owenerId;
		//处理第一张卡片
		jp1=new JPanel(new BorderLayout());		
		//假定好友有50个
		jp2=new JPanel(new GridLayout(50, 1,4,4));
		
		JLabel jlbs[] = new JLabel[50];
		for(int i=0;i<jlbs.length;i++){
			jlbs[i]=new JLabel(i+1+"",new ImageIcon("images/qqhead.jpg"),JLabel.LEFT);
			jlbs[i].addMouseListener(this);
			jp2.add(jlbs[i]);
		}
		
		jp3= new JPanel(new GridLayout(2,1));
		jsp=new JScrollPane(jp2);
		
		jb1=new JButton("我的好友");
		jb2=new JButton("陌生人");
		jb2.addActionListener(this);		
		jb3=new JButton("黑名单");
		
		jp3.add(jb2);
		jp3.add(jb3);		
		
		
		jp1.add(jb1,"North");
		jp1.add(jsp,"Center");
		jp1.add(jp3,"South");
		
		
		//处理第二张卡片
		
		jpmsr1=new JPanel(new BorderLayout());		
		//假定好友有20个		
		jpmsr3= new JPanel(new GridLayout(2,1));
		jpmsr2=new JPanel(new GridLayout(20, 1,4,4));
		
		JLabel jlbs2[] = new JLabel[20];
		for(int i=0;i<jlbs2.length;i++){
			jlbs2[i]=new JLabel(i+1+"",new ImageIcon("images/qqhead.jpg"),JLabel.LEFT);
			jlbs2[i].addMouseListener(this);
			
			jpmsr2.add(jlbs2[i]);
		}		
		
		jspmsr=new JScrollPane(jpmsr2);	
		
		jbmsr1=new JButton("我的好友");
		jbmsr2=new JButton("陌生人");		
		jbmsr2.addActionListener(this);
		
		jbmsr3=new JButton("黑名单");
		//加入两个button
		jpmsr3.add(jbmsr1);
		jpmsr3.add(jbmsr2);		
		
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(jspmsr,"Center");
		jpmsr1.add(jbmsr3,"South");
		
		
		
		//设置成卡片布局
		cl=new CardLayout();
		this.setLayout(cl);
		
		
		this.add(jp1,"1");
		
		
		this.add(jp1,"Center");
		this.setSize(160,400);
		this.setLocation(400, 300);
		this.setVisible(true);
		this.setTitle(owenerId);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb2){			
			this.add(jpmsr1,"2");
			cl.show(this.getContentPane(), "2");
		}else if(e.getSource()==jbmsr2){
			this.add(jp1,"1");
			cl.show(this.getContentPane(),"1");
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			String frendno = ((JLabel)e.getSource()).getText();
			//System.out.println("你想和"+gettext+"聊天");
			new QqChat(this.owenerId,frendno);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.black);
	}

}
