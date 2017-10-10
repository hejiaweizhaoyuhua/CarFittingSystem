package com.example.jpanel;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class BaseJPanel extends JPanel implements IJPanel{
	public BaseJPanel(int LocationX, int LocationY, 
			int width, int height, LayoutManager manager){
		setLocation(LocationX, LocationY);
		setSize(width, height);
		setLayout(manager);
		
		showUI();
	}
}
