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
		mainFrame = new JFrame("汽配查询系统");
		
		screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		width = 650;
		height = 450;
	}
	
	public void showGUI(){
		prepareTitle();
		preparePanel();
		// 如果不放到最后，控件显示会出现不全的问题
		prepareMainFrame();
	}
	
	private void prepareMainFrame() {
		// 设置居中
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
		// 公司标题
		JPanel titlePanel = new JPanel();
		titlePanel.setSize(width, 40);
		titlePanel.setLocation(0, 0);
		titlePanel.setBackground(new Color(127, 205, 233));
		titlePanel.setLayout(null);
		
		mainFrame.add(titlePanel);
		
		JLabel companyTitle = new JLabel("XX公司");
		companyTitle.setLocation(20, 0);
		companyTitle.setSize(140, 40);
		companyTitle.setFont(new Font("微软斜黑", Font.BOLD, 20));
		companyTitle.setForeground(new Color(255, 255, 240));
		
		titlePanel.add(companyTitle);
		
		// 系统标题
		JLabel systemTitle = new JLabel("汽配查询系统", JLabel.CENTER);
		systemTitle.setLocation(150, 70);
		systemTitle.setSize(140, 30);
		systemTitle.setFont(new Font("微软斜黑", Font.BOLD, 22));
		systemTitle.setForeground(new Color(255, 255, 248));
		
		mainFrame.add(systemTitle);
	}
	
	private void preparePanel() {
		int panelWidth = 370; 
		int panelHeight = 260;
		
		// 容器
		jPanel = new RoundRectPanel(0, 0);
		jPanel.setSize(panelWidth, panelHeight);
		jPanel.setLocation((width - panelWidth) / 2, 
				(height - panelHeight + 30) / 2);
		jPanel.setBorder(new RoundRectBorder(new Color(79, 103, 175), 30));
		jPanel.setBackground(new Color(255, 255, 248));
		jPanel.setLayout(null);
		
	    mainFrame.add(jPanel);
	    
	    // 容器边框
 		borderJPanel = new JPanel();
 		borderJPanel.setSize(panelWidth + 10, panelHeight + 10);
 		borderJPanel.setLocation((width - panelWidth) / 2 - 5, 
 				(height - panelHeight + 30) / 2 - 5);
 		borderJPanel.setBackground(new Color(79, 103, 175));
 		
 		mainFrame.add(borderJPanel);
	    
	    // 用户登陆字体
	    userLogin = new JLabel("用户登陆    User Login");
	    userLogin.setLocation(20, 25);
	    userLogin.setSize(250, 25);
	    userLogin.setFont(new Font("微软斜黑", Font.BOLD, 21));
	    userLogin.setForeground(new Color(0, 0, 255));
	    
	    jPanel.add(userLogin);
	    
	    // 用户名
	    userName = new JLabel("用户名：");
	    userName.setLocation(20, 90);
	    userName.setSize(80, 25);
	    userName.setFont(new Font("微软斜黑", 0, 19));
	    userName.setForeground(new Color(0, 0, 255));
	    
	    userNameField = new JTextField();
	    userNameField.setSize(120, 25);
	    userNameField.setLocation(100, 90);
	    
	    jPanel.add(userName);
	    jPanel.add(userNameField);
	    
	    // 密码
	    password = new JLabel("密码：");
	    password.setLocation(20, 150);
	    password.setSize(80, 25);
	    password.setFont(new Font("微软斜黑", 0, 19));
	    password.setForeground(new Color(0, 0, 255));
	    
	    passwordField = new JPasswordField();
	    passwordField.setSize(120, 25);
	    passwordField.setLocation(100, 150);
	    
	    jPanel.add(password);
	    jPanel.add(passwordField);
	    
	    // 登陆
	    loginButton = new RadiusJButton("登录");
	    loginButton.setLocation(70, 210);
	    loginButton.setSize(80, 30);
	    loginButton.setFont(new Font("微软斜黑", 0, 17));
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
	    
	    //取消
	    exitButton = new RadiusJButton("取消");
	    exitButton.setLocation(210, 210);
	    exitButton.setSize(80, 30);
	    exitButton.setFont(new Font("微软斜黑", 0, 17));
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
