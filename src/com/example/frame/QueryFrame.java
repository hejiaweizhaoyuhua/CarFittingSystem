package com.example.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.example.jpanel.QueryFirstPanel;
import com.example.jpanel.QuerySecondPanel;
import com.example.jpanel.QueryThirdPanel;

public class QueryFrame {
	private JFrame mainFrame;
	
	private int screenWidth, screenHeight;
	private int taskHeight;
	
	private int visiblePanel;
	
	private JLabel carTypeLabel;
	private JComboBox<String> carTypeBox;
	private String carType;
	
	/*****************车型年款查询********************/
	private JLabel firstLabel;
	private QueryFirstPanel firstPanel;
	
	/*****************VIN码查询********************/
	private JLabel secondLabel;
	private QuerySecondPanel secondPanel;
	
	/*****************配件编码查询********************/
	private JLabel thirdLabel;
	private QueryThirdPanel thirdPanel;
	
	public QueryFrame(){
		mainFrame = new JFrame("汽配查询系统");
		
		screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		taskHeight = Toolkit.getDefaultToolkit().getScreenInsets(
				mainFrame.getGraphicsConfiguration()).bottom;
	}
	
	public void showGUI(){
		prepareMainFrameUI();
		prepareLab();
		prepareMainFrame();
	}
	
	private void prepareMainFrame(){
		mainFrame.setSize(screenWidth, screenHeight - taskHeight);
		mainFrame.setLocation(0, 0);
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);
		mainFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});
		
		mainFrame.setVisible(true);
	}
	
	private void prepareMainFrameUI(){ 
		carTypeLabel = new JLabel("车型:");
		carTypeLabel.setLocation(20, 30);
		carTypeLabel.setSize(40,25);
		carTypeLabel.setFont(new Font("微软斜黑", 1, 15));
		
		mainFrame.add(carTypeLabel);
		
		carTypeBox = new JComboBox<>();
		carTypeBox.setLocation(70, 30);
		carTypeBox.setSize(120, 25);
		carTypeBox.setFont(new Font("微软斜黑", 0, 14));
		carTypeBox.setFocusable(false);
		carTypeBox.setOpaque(true);
		carTypeBox.setBackground(Color.WHITE);
		
		carTypeBox.addItem("保时捷");
		carTypeBox.addItem("奔驰");
		carTypeBox.addItem("法拉利");
		
		setSelectItem(carTypeBox.getItemAt(0));
		
		carTypeBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				setSelectItem((String) e.getItem());
			}
		});
		
		mainFrame.add(carTypeBox);
	}
	
	private void setSelectItem(String item){
		carType = item;
		System.out.println("选择的车型为：" + carType);
	}
	
	private void prepareLab(){
		int labelLocationX = 20, labelLocationY = 60;
		
		firstLabel = new JLabel("汽车年款查询", JLabel.CENTER);
		firstLabel.setLocation(20, labelLocationY);
		firstLabel.setSize(105, 22);
		firstLabel.setFont(new Font("微软斜黑", 0, 15));
		firstLabel.setOpaque(true);
		
		firstLabel.addMouseListener(new MyMouseListener(1));
		
		firstPanel = new QueryFirstPanel(20, labelLocationY + 22, 
				screenWidth - labelLocationY, 
				screenHeight - taskHeight - 120, null);
		
		mainFrame.add(firstLabel);
		mainFrame.add(firstPanel);
		
		secondLabel = new JLabel("VIN码查询", JLabel.CENTER);
		secondLabel.setLocation(130, labelLocationY);
		secondLabel.setSize(100, 22);
		secondLabel.setFont(new Font("微软斜黑", 0, 15));
		secondLabel.setOpaque(true);
		secondLabel.addMouseListener(new MyMouseListener(2));
		
		secondPanel = new QuerySecondPanel(20, labelLocationY + 22, 
				screenWidth - labelLocationY, 
				screenHeight - taskHeight - 120, null);
		
		mainFrame.add(secondLabel);
		mainFrame.add(secondPanel);
		
		thirdLabel = new JLabel("配件编码查询", JLabel.CENTER);
		thirdLabel.setLocation(235, labelLocationY);
		thirdLabel.setSize(100, 22);
		thirdLabel.setFont(new Font("微软斜黑", 0, 15));
		thirdLabel.setOpaque(true);
		thirdLabel.addMouseListener(new MyMouseListener(3));
		
		thirdPanel = new QueryThirdPanel(20, labelLocationY + 22, 
				screenWidth - labelLocationY, 
				screenHeight - taskHeight - 120, null);
		thirdPanel.setLayout(null);
		
		mainFrame.add(thirdLabel);
		mainFrame.add(thirdPanel);
		
		switchLab(1);
	}
	
	private void switchLab(int num){
		visiblePanel = num;
		
		if (num == 1) {
			firstLabel.setBorder(BorderFactory.createLineBorder(
					new Color(0, 169, 222), 1));
			firstLabel.setBackground(new Color(0, 169, 222));
			firstLabel.setForeground(Color.WHITE);
			firstPanel.setVisible(true);
			
			secondLabel.setBorder(BorderFactory.createLineBorder(
					Color.BLACK, 1));
			secondLabel.setBackground(Color.WHITE);
			secondLabel.setForeground(Color.BLACK);
			secondPanel.setVisible(false);
			
			thirdLabel.setBorder(BorderFactory.createLineBorder(
					Color.BLACK, 1));
			thirdLabel.setBackground(Color.WHITE);
			thirdLabel.setForeground(Color.BLACK);
			thirdPanel.setVisible(false);
		} else if (num == 2){
			firstLabel.setBorder(BorderFactory.createLineBorder(
					Color.BLACK, 1));
			firstLabel.setBackground(Color.WHITE);
			firstLabel.setForeground(Color.BLACK);
			firstPanel.setVisible(false);
			
			secondLabel.setBorder(BorderFactory.createLineBorder(
					new Color(0, 169, 222), 1));
			secondLabel.setBackground(new Color(0, 169, 222));
			secondLabel.setForeground(Color.WHITE);
			secondPanel.setVisible(true);
			
			thirdLabel.setBorder(BorderFactory.createLineBorder(
					Color.BLACK, 1));
			thirdLabel.setBackground(Color.WHITE);
			thirdLabel.setForeground(Color.BLACK);
			thirdPanel.setVisible(false);
		} else if (num == 3){
			firstLabel.setBorder(BorderFactory.createLineBorder(
					Color.BLACK, 1));
			firstLabel.setBackground(Color.WHITE);
			firstLabel.setForeground(Color.BLACK);
			firstPanel.setVisible(false);
			
			secondLabel.setBorder(BorderFactory.createLineBorder(
					Color.BLACK, 1));
			secondLabel.setBackground(Color.WHITE);
			secondLabel.setForeground(Color.BLACK);
			secondPanel.setVisible(false);
			
			thirdLabel.setBorder(BorderFactory.createLineBorder(
					new Color(0, 169, 222), 1));
			thirdLabel.setBackground(new Color(0, 169, 222));
			thirdLabel.setForeground(Color.WHITE);
			thirdPanel.setVisible(true);
		}
	}
	
	private void onMouseEntered(int num){
		if (visiblePanel != num) {
			if (num == 1) {
				firstLabel.setBackground(new Color(220, 220, 220));
			} else if (num == 2){
				secondLabel.setBackground(new Color(220, 220, 220));
			} else if (num == 3){
				thirdLabel.setBackground(new Color(220, 220, 220));
			}
		}
	}
	
	private void onMouseExited(int num){
		if (visiblePanel != num) {
			if (num == 1) {
				firstLabel.setBackground(Color.WHITE);
			} else if (num == 2){
				secondLabel.setBackground(Color.WHITE);
			} else if (num == 3){
				thirdLabel.setBackground(Color.WHITE);
			}
		}
	}
	
	private class MyMouseListener implements MouseListener{
		private int num;
		
		public MyMouseListener(int num){
			this.num = num;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switchLab(num);
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
			onMouseEntered(num);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			onMouseExited(num);
		}
		
	}
}
