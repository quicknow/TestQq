/*
 * qq客户端登陆界面
 */
package com.qq.client.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.qq.client.model.*;
import com.qq.common.*;
public class QqClientLogin extends JFrame implements ActionListener{
	
	//定义北部区域
	JLabel jbl1=null;
	
	//定义中部区域
	
	JLabel jbl2=null;
	JLabel jbl3=null;
	JLabel jbl4=null;
	JLabel jbl5=null;
	
	JButton jb4=null;
	JCheckBox jcb1=null;
	JCheckBox jcb2=null;
	JTextField jtf1=null;
	JPasswordField jpf2=null;
	JPanel jp2 = null;
	JPanel jp3 = null;
	JPanel jp4 = null;
	JTabbedPane jtp=null;
	//定义南部区域
	JPanel jp=null;
	JButton jb1=null;
	JButton jb2=null;
	JButton jb3=null;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqClientLogin qq = new QqClientLogin();
	}
	
	public QqClientLogin(){
		//南部
		jp = new JPanel();
		jb1= new JButton(new ImageIcon("images/login.gif"));
		jb1.addActionListener(this);
		
		jb2= new JButton(new ImageIcon("images/zhuce.gif"));
		jb3= new JButton(new ImageIcon("images/zcxd.gif"));
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		
		//中部
		jbl2=new JLabel("QQ号码",JLabel.CENTER);
		jbl3=new JLabel("QQ密码",JLabel.CENTER);
		jbl4=new JLabel("忘记密码",JLabel.CENTER);
		jbl5=new JLabel("申请密码保护",JLabel.CENTER);
		jbl5.setForeground(Color.blue);
		jb4=new JButton(new ImageIcon("images/qchma.gif"));
		
		jtf1= new JTextField();
		jpf2= new JPasswordField();
		
		jcb1=new JCheckBox("隐身登陆");
		jcb2=new JCheckBox("记住密码");
		
		jp2=new JPanel(new GridLayout(3, 3));
		
		jp2.add(jbl2);
		jp2.add(jtf1);
		jp2.add(jb4);
		
		jp2.add(jbl3);
		jp2.add(jpf2);
		jp2.add(jbl4);
		
		jp2.add(jcb1);
		jp2.add(jcb2);
		jp2.add(jbl5);
		
		//创建选项卡
		jtp=new JTabbedPane();
		jtp.add("QQ号码",jp2);
		jp3= new JPanel();
		jp4=new JPanel();
		jtp.add("手机号码",jp3);		
		jtp.add("电子邮箱",jp4);
		
		this.add(jtp);		
	
		//处理北部
		
		jbl1 = new JLabel(new ImageIcon("images/tou.gif"));
		
		this.add(jp,BorderLayout.SOUTH);
		this.add(jbl1,"North");				
		this.setSize(450,300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			QqClientUser qcu= new QqClientUser();
			//组建一个对象流包
			User u= new User();
			u.setName(jtf1.getText().trim());
			u.setPass(new String(jpf2.getPassword()));
			
			//如果服务端验证成功则弹出好友界面否则弹出提示
			if(qcu.checkUser(u)){
				new QqFriendList(u.getName());
				//关闭当前登陆框
				this.dispose();
			}else{
				
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
			}
		}
	}
	
	
	

}
