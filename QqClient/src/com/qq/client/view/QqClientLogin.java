/*
 * qq�ͻ��˵�½����
 */
package com.qq.client.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.qq.client.model.*;
import com.qq.common.*;
public class QqClientLogin extends JFrame implements ActionListener{
	
	//���山������
	JLabel jbl1=null;
	
	//�����в�����
	
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
	//�����ϲ�����
	JPanel jp=null;
	JButton jb1=null;
	JButton jb2=null;
	JButton jb3=null;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqClientLogin qq = new QqClientLogin();
	}
	
	public QqClientLogin(){
		//�ϲ�
		jp = new JPanel();
		jb1= new JButton(new ImageIcon("images/login.gif"));
		jb1.addActionListener(this);
		
		jb2= new JButton(new ImageIcon("images/zhuce.gif"));
		jb3= new JButton(new ImageIcon("images/zcxd.gif"));
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		
		//�в�
		jbl2=new JLabel("QQ����",JLabel.CENTER);
		jbl3=new JLabel("QQ����",JLabel.CENTER);
		jbl4=new JLabel("��������",JLabel.CENTER);
		jbl5=new JLabel("�������뱣��",JLabel.CENTER);
		jbl5.setForeground(Color.blue);
		jb4=new JButton(new ImageIcon("images/qchma.gif"));
		
		jtf1= new JTextField();
		jpf2= new JPasswordField();
		
		jcb1=new JCheckBox("�����½");
		jcb2=new JCheckBox("��ס����");
		
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
		
		//����ѡ�
		jtp=new JTabbedPane();
		jtp.add("QQ����",jp2);
		jp3= new JPanel();
		jp4=new JPanel();
		jtp.add("�ֻ�����",jp3);		
		jtp.add("��������",jp4);
		
		this.add(jtp);		
	
		//������
		
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
			//�齨һ����������
			User u= new User();
			u.setName(jtf1.getText().trim());
			u.setPass(new String(jpf2.getPassword()));
			
			//����������֤�ɹ��򵯳����ѽ�����򵯳���ʾ
			if(qcu.checkUser(u)){
				new QqFriendList(u.getName());
				//�رյ�ǰ��½��
				this.dispose();
			}else{
				
				JOptionPane.showMessageDialog(this,"�û������������");
			}
		}
	}
	
	
	

}
