package com.example.ui;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class QueryInterface {
	private JFrame mainFrame;
	
	private int screenWidth, screenHeight;
	private int taskHeight;
	
	public QueryInterface(){
		mainFrame = new JFrame("ÆûÅä²éÑ¯ÏµÍ³");
		
		screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		taskHeight = Toolkit.getDefaultToolkit().getScreenInsets(
				mainFrame.getGraphicsConfiguration()).bottom;
	}
	
	public void showGUI(){
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
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		mainFrame.setVisible(true);
	}
}
