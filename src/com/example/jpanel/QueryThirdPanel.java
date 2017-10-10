package com.example.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.example.component.RadiusJButton;

public class QueryThirdPanel extends BaseJPanel{
	private JComboBox<String> fittingsCode;
	private RadiusJButton queryButton;
	
	private JLabel carTypeJLabel;
	private JList<String> carTypeResult;
	private JLabel fittingsPicture;
	
	public QueryThirdPanel(int LocationX, int LocationY, int width, 
			int height, LayoutManager manager) {
		super(LocationX, LocationY, width, height, manager);
	}

	@Override
	public void showUI() {
		prepareFittingsQuery();
		prepareCarTypeResult();
		prepareFittingsPicture();
	}
	
	private void prepareFittingsQuery(){
		fittingsCode = new JComboBox<>();
		fittingsCode.setLocation(20, 10);
		fittingsCode.setSize(150, 25);
		fittingsCode.setFont(new Font("微软斜黑", 0, 14));
		fittingsCode.setOpaque(true);
		fittingsCode.setEditable(true);
		fittingsCode.setBackground(Color.WHITE);
		
		fittingsCode.addItem("111");
		fittingsCode.addItem("222");
		fittingsCode.addItem("333");
		// 设置不显示任何值
		fittingsCode.setSelectedIndex(-1);
		// 设置提示语
		final JTextField textField = (JTextField) fittingsCode.getEditor().
				getEditorComponent();
		textField.setText(" 配件编码查询");
		textField.setForeground(new Color(200, 200, 200));
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				textField.setText(" 配件编码查询");
				textField.setForeground(new Color(200, 200, 200));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
				textField.setForeground(Color.BLACK);
			}
		});
		
		add(fittingsCode);
		
		queryButton = new RadiusJButton("查询");
		queryButton.setSize(70, 25);
		queryButton.setLocation(200, 10);
		queryButton.setFont(new Font("微软斜黑", 0, 15));
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		add(queryButton);
	}
	
	private void prepareCarTypeResult(){
		carTypeJLabel = new JLabel("车型", JLabel.CENTER);
		carTypeJLabel.setFont(new Font("微软斜黑", 0, 15));
		carTypeJLabel.setLocation(100 + (250 / 2 - 50), 60);
		carTypeJLabel.setSize(100, 20);
		
		add(carTypeJLabel);
		
		carTypeResult = new JList<>();
		carTypeResult.setLocation(100, 85);
		carTypeResult.setSize(250, 370);
		carTypeResult.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(carTypeResult);
	}
	
	private void prepareFittingsPicture(){
		fittingsPicture = new JLabel();
		fittingsPicture.setLocation(500, 60);
		fittingsPicture.setSize(500, 500);
		fittingsPicture.setOpaque(true);
		fittingsPicture.setBackground(Color.WHITE);
		fittingsPicture.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(fittingsPicture);
	}
}
