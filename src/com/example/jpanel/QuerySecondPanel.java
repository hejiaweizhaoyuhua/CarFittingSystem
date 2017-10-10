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
import javax.swing.JTable;
import javax.swing.JTextField;

import com.example.component.RadiusJButton;

public class QuerySecondPanel extends BaseJPanel{
	
	private JComboBox<String> VINCode;
	private RadiusJButton queryButton;
	private JTable resultJTable;
	
	public QuerySecondPanel(int LocationX, int LocationY, int width,
			int height, LayoutManager manager) {
		super(LocationX, LocationY, width, height, manager);
	}

	@Override
	public void showUI() {
		prepareVINQuery();
		prepareResultTable();
	}
	
	private void prepareVINQuery(){
		VINCode = new JComboBox<>();
		VINCode.setLocation(20, 10);
		VINCode.setSize(150, 25);
		VINCode.setFont(new Font("微软斜黑", 0, 14));
		VINCode.setOpaque(true);
		VINCode.setEditable(true);
		VINCode.setBackground(Color.WHITE);
		
		VINCode.addItem("111");
		VINCode.addItem("222");
		VINCode.addItem("333");
		// 设置不显示任何值
		VINCode.setSelectedIndex(-1);
		// 设置提示语
		final JTextField textField = (JTextField) VINCode.getEditor().
				getEditorComponent();
		textField.setText(" VIN码查询");
		textField.setForeground(new Color(200, 200, 200));
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				textField.setText(" VIN码查询");
				textField.setForeground(new Color(200, 200, 200));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
				textField.setForeground(Color.BLACK);
			}
		});
		
		add(VINCode);
		
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
	
	private void prepareResultTable(){
		resultJTable = new JTable();
		resultJTable.setLocation(20, 50);
		resultJTable.setSize(getWidth() - 40, getHeight() - 70);
		resultJTable.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(resultJTable);
	}
}
