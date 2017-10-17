package com.example.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import okhttp3.Call;

import com.example.callback.NetCallback;
import com.example.component.RadiusJButton;
import com.example.component.RoundRectBorder;
import com.example.component.RoundRectPanel;
import com.example.component.WaitingDialog;
import com.example.constants.DataConstants;
import com.example.constants.PathConstants;
import com.example.constants.URLConstans;
import com.example.entity.UserDataEntity;
import com.example.entity.respone.LoginEntity;
import com.example.network.OkHttpUtils;
import com.example.utils.FileUtils;
import com.example.utils.JsonUtils;
import com.example.utils.StringUtils;

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
	
	private WaitingDialog dialog;
	
	public LoginFrame(){
		mainFrame = new JFrame("汽配查询系统");
		
		screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		width = 650;
		height = 450;
	}
	
	public void showGUI(){
		prepareDialog();
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
		
		// 读取上次登录的用户名
		String username = null;
		try {
			String data = FileUtils.readFile(PathConstants.DATA_PATH, 
					DataConstants.USERNAME);
			if (!StringUtils.isNull(data)) {
				UserDataEntity entity = JsonUtils.formJson(data, 
						UserDataEntity.class);
				username = entity.getUsername();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
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
	    if (!StringUtils.isNull(username)) {
			userNameField.setText(username);
		}
	    userNameField.setCaretPosition(userNameField.getText().length());
	    
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
//				if (StringUtils.isNull(userNameField.getText())) {
//					JOptionPane.showConfirmDialog(mainFrame, 
//							"请输入用户名", "提示", 
//							JOptionPane.CLOSED_OPTION);
//					
//					return;
//				}
//				
//				if (StringUtils.isNull(passwordField.getText())) {
//					JOptionPane.showConfirmDialog(mainFrame, 
//							"请输入密码", "提示", 
//							JOptionPane.CLOSED_OPTION);
//					
//					return;
//				}
//				
//				setDialogVisiable(true);
//				
//				HashMap<String, String> map = new HashMap<String, String>();
//				map.put("username", userNameField.getText());
//				map.put("password", passwordField.getText());
//				OkHttpUtils.post(URLConstans.URL_LOGIN, map, new NetCallback(){
//
//					@Override
//					public void onResponseSuccess(String result){
//						setDialogVisiable(false);
//						
//						LoginEntity loginEntity = JsonUtils.formJson(
//								result, LoginEntity.class);
//						// 保存账户信息
//						UserDataEntity userEntity = new UserDataEntity();
//						userEntity.setUsername(userNameField.getText());
//						try {
//							FileUtils.writeToFile(
//									PathConstants.DATA_PATH, 
//									DataConstants.USERNAME, 
//									JsonUtils.toJson(userEntity));
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//						// 切换页面
//						QueryFrame queryInterface = new QueryFrame();
//						queryInterface.showGUI();
//						
//						mainFrame.setVisible(false);
//					}
//
//					@Override
//					public void onResponseFail(String result, String failReason) {
//						setDialogVisiable(false);
//						
//						JOptionPane.showConfirmDialog(mainFrame, 
//								failReason, "提示", 
//								JOptionPane.CLOSED_OPTION);
//					}
//
//					@Override
//					public void onFail(Call arg0, IOException arg1) {
//						setDialogVisiable(false);
//					}
//					
//				});
				
				// 切换页面
				QueryFrame queryInterface = new QueryFrame();
				queryInterface.showGUI();
				
				mainFrame.setVisible(false);
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
	
	private void prepareDialog(){
		dialog = new WaitingDialog(width / 2 - 100, 
				height / 2 - 50, 200, 100, Color.BLACK);
		dialog.setTransparent(0.5f);
		dialog.setVisible(false);
		
		mainFrame.add(dialog);
	}
	
	private void setDialogVisiable(boolean visible){
		if (visible) {
			dialog.setVisible(true);
			dialog.startAnimation();
		} else {
			dialog.setVisible(false);
			dialog.stopAnimation();
		}
	}
}
