package com.example.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.component.RadiusJButton;
import com.example.component.RoundRectBorder;
import com.example.component.RoundRectPanel;

public class LoginFrame {
	private JFrame mainFrame;
	
	private int screenWidth, screenHeight;
	private final int width, height;
	
	private RoundRectPanel jPanel;
	private JPanel borderJPanel;
	
	private JLabel userLogin;
	private JLabel userName;
	private JTextField userNameField;
	private JLabel password;
	private JPasswordField passwordField;
	
	private RadiusJButton loginButton;
	private RadiusJButton exitButton;
	
	public LoginFrame(){
		mainFrame = new JFrame("�����ѯϵͳ");
		
		screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		width = 650;
		height = 450;
	}
	
	public void showGUI(){
		prepareTitle();
		preparePanel();
		// ������ŵ���󣬿ؼ���ʾ����ֲ�ȫ������
		prepareMainFrame();
	}
	
	private void prepareMainFrame() {
		// ���þ���
		mainFrame.setSize(width, height);
		mainFrame.setLocation((screenWidth - width) / 2, 
				(screenHeight - height) / 2);
		
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);
		mainFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		mainFrame.getContentPane().setBackground(new Color(0, 169, 222));
		mainFrame.getContentPane().setVisible(true);
		
	    mainFrame.setVisible(true);
	}
	
	private void prepareTitle(){
		// ��˾����
		JPanel titlePanel = new JPanel();
		titlePanel.setSize(width, 40);
		titlePanel.setLocation(0, 0);
		titlePanel.setBackground(new Color(127, 205, 233));
		titlePanel.setLayout(null);
		
		mainFrame.add(titlePanel);
		
		JLabel companyTitle = new JLabel("XX��˾");
		companyTitle.setLocation(20, 0);
		companyTitle.setSize(140, 40);
		companyTitle.setFont(new Font("΢��б��", Font.BOLD, 20));
		companyTitle.setForeground(new Color(255, 255, 240));
		
		titlePanel.add(companyTitle);
		
		// ϵͳ����
		JLabel systemTitle = new JLabel("�����ѯϵͳ", JLabel.CENTER);
		systemTitle.setLocation(150, 70);
		systemTitle.setSize(140, 30);
		systemTitle.setFont(new Font("΢��б��", Font.BOLD, 22));
		systemTitle.setForeground(new Color(255, 255, 248));
		
		mainFrame.add(systemTitle);
	}
	
	private void preparePanel() {
		int panelWidth = 370; 
		int panelHeight = 260;
		
		// ����
		jPanel = new RoundRectPanel(0, 0);
		jPanel.setSize(panelWidth, panelHeight);
		jPanel.setLocation((width - panelWidth) / 2, 
				(height - panelHeight + 30) / 2);
		jPanel.setBorder(new RoundRectBorder(new Color(79, 103, 175), 30));
		jPanel.setBackground(new Color(255, 255, 248));
		jPanel.setLayout(null);
		
	    mainFrame.add(jPanel);
	    
	    // �����߿�
 		borderJPanel = new JPanel();
 		borderJPanel.setSize(panelWidth + 10, panelHeight + 10);
 		borderJPanel.setLocation((width - panelWidth) / 2 - 5, 
 				(height - panelHeight + 30) / 2 - 5);
 		borderJPanel.setBackground(new Color(79, 103, 175));
 		
 		mainFrame.add(borderJPanel);
	    
	    // �û���½����
	    userLogin = new JLabel("�û���½    User Login");
	    userLogin.setLocation(20, 25);
	    userLogin.setSize(250, 25);
	    userLogin.setFont(new Font("΢��б��", Font.BOLD, 21));
	    userLogin.setForeground(new Color(0, 0, 255));
	    
	    jPanel.add(userLogin);
	    
	    // �û���
	    userName = new JLabel("�û�����");
	    userName.setLocation(20, 90);
	    userName.setSize(80, 25);
	    userName.setFont(new Font("΢��б��", 0, 19));
	    userName.setForeground(new Color(0, 0, 255));
	    
	    userNameField = new JTextField();
	    userNameField.setSize(120, 25);
	    userNameField.setLocation(100, 90);
	    
	    jPanel.add(userName);
	    jPanel.add(userNameField);
	    
	    // ����
	    password = new JLabel("���룺");
	    password.setLocation(20, 150);
	    password.setSize(80, 25);
	    password.setFont(new Font("΢��б��", 0, 19));
	    password.setForeground(new Color(0, 0, 255));
	    
	    passwordField = new JPasswordField();
	    passwordField.setSize(120, 25);
	    passwordField.setLocation(100, 150);
	    
	    jPanel.add(password);
	    jPanel.add(passwordField);
	    
	    // ��½
	    loginButton = new RadiusJButton("��¼");
	    loginButton.setLocation(70, 210);
	    loginButton.setSize(80, 30);
	    loginButton.setFont(new Font("΢��б��", 0, 17));
	    loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QueryFrame queryInterface = new QueryFrame();
				queryInterface.showGUI();
				
				mainFrame.setVisible(false);
				
//				OkHttpUtils.get("https://raw.github.com/square/" +
//						"okhttp/master/README.md", new NetCallback(){
//
//							@Override
//							public void onFailure(Call arg0, IOException arg1) {
//								super.onFailure(arg0, arg1);
//							}
//
//							@Override
//							public void onResponse(Call arg0, Response arg1)
//									throws IOException {
//								super.onResponse(arg0, arg1);
//							}
//					
//				});
				
//				OkHttpUtils.download("http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201204/20120412123904521.jpg", 
//						new FileDownloadCallback() {
//					
//					@Override
//					public void downloadSuccess(String path) {
//						
//					}
//					
//					@Override
//					public void downloadFail(String error) {
//						
//					}
//				});
			}
		});
	    
	    jPanel.add(loginButton);
	    
	    //ȡ��
	    exitButton = new RadiusJButton("ȡ��");
	    exitButton.setLocation(210, 210);
	    exitButton.setSize(80, 30);
	    exitButton.setFont(new Font("΢��б��", 0, 17));
	    exitButton.setBackground(Color.ORANGE);
	    exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	    
	    jPanel.add(exitButton);
	}
	
}
