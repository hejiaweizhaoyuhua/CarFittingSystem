package com.example.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class QueryFirstPanel extends BaseJPanel{
	private JLabel yearTypeLabel;
	private JList<String> yearTypeList; // ������б��б�
	private JLabel fittingsTypeLabel;
	private JList<String> fittingsTypeList; // ��������б�
	private JLabel fittingsChildLabel;
	private JList<String> fittingsChildList; // ��������б�
	private JLabel fittingsLabel;
	private JList<String> fittingsList; // ����б�
	private JLabel fittingPicture;
	
	public QueryFirstPanel(int LocationX, int LocationY, int width, 
			int height, LayoutManager manager) {
		super(LocationX, LocationY, width, height, manager);
	}
	
	@Override
	public void showUI() {
		prepareYearType();
		prepareFittingsType();
		prepareFittingsChild();
		prepareFittingsList();
		prepareFittingPicure();
	}
	
	private void prepareYearType(){
		yearTypeLabel = new JLabel("�������", JLabel.CENTER);
		yearTypeLabel.setFont(new Font("΢��б��", 0, 15));
		yearTypeLabel.setLocation(30 + (200 / 2 - 50), 5);
		yearTypeLabel.setSize(100, 20);
		
		add(yearTypeLabel);
		
		yearTypeList = new JList<>();
		yearTypeList.setLocation(30, 25);
		yearTypeList.setSize(200, 270);
		yearTypeList.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(yearTypeList);
	}
	
	private void prepareFittingsType(){
		fittingsTypeLabel = new JLabel("�������", JLabel.CENTER);
		fittingsTypeLabel.setFont(new Font("΢��б��", 0, 15));
		fittingsTypeLabel.setLocation(270 + (200 / 2 - 50), 5);
		fittingsTypeLabel.setSize(100, 20);
		
		add(fittingsTypeLabel);
		
		fittingsTypeList = new JList<>();
		fittingsTypeList.setLocation(270, 25);
		fittingsTypeList.setSize(200, 270);
		fittingsTypeList.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(fittingsTypeList);
	}
	
	private void prepareFittingsChild(){
		fittingsChildLabel = new JLabel("����", JLabel.CENTER);
		fittingsChildLabel.setFont(new Font("΢��б��", 0, 15));
		fittingsChildLabel.setLocation(510 + (200 / 2 - 50), 5);
		fittingsChildLabel.setSize(100, 20);
		
		add(fittingsChildLabel);
		
		fittingsChildList = new JList<>();
		fittingsChildList.setLocation(510, 25);
		fittingsChildList.setSize(200, 270);
		fittingsChildList.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(fittingsChildList);
	}
	
	private void prepareFittingsList(){
		fittingsLabel = new JLabel("���", JLabel.CENTER);
		fittingsLabel.setFont(new Font("΢��б��", 0, 15));
		fittingsLabel.setLocation(30 + (680 / 2 - 50), 300);
		fittingsLabel.setSize(100, 20);
		
		add(fittingsLabel);
		
		fittingsList = new JList<>();
		fittingsList.setLocation(30, 320);
		fittingsList.setSize(680, 270);
		fittingsList.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(fittingsList);
	}
	
	private void prepareFittingPicure(){
		fittingPicture = new JLabel();
		fittingPicture.setSize(500, 500);
		// ����
		fittingPicture.setLocation(750 + (getWidth() - 750) / 2 - 250, 
				getHeight() / 2 - 250);
		fittingPicture.setOpaque(true);
		fittingPicture.setBackground(Color.WHITE);
		fittingPicture.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(fittingPicture);
	}
	
}
