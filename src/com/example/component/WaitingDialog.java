package com.example.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WaitingDialog extends JPanel{
	private float transparency;
	
	private JLabel label;
	
	private Timer timer;
	private int count;
	
	public WaitingDialog(int locationX, int locationY, 
			int width, int height, Color color){
		setLocation(locationX, locationY);
		setSize(width, height);
		setBackground(color);
		setOpaque(false);
		setLayout(null);
		
		prepareLabel(width, height);
	}
	
	private void prepareLabel(int width, int height){
		count = 3;
		
		label = new JLabel("«Î…‘∫Û...", JLabel.CENTER);
		label.setSize(100, 30);
		label.setLocation(width / 2 - 50, height / 2 - 15);
		label.setFont(new Font("Œ¢»Ì–±∫⁄", 0, 20));
		label.setForeground(Color.WHITE);
		
		add(label);
	}
	
	/**
	 * ø™ º∂Øª≠
	 */
	public void startAnimation(){
		if (timer == null){
			timer = new Timer(1000, new CountDownTimer());
		}
		timer.start();
	}
	
	/**
	 * Õ£÷π∂Øª≠
	 */
	public void stopAnimation(){
		if (timer != null)
			timer.stop();
	}
	
	public void setTransparent(float transparency) {  
        this.transparency = transparency;  
    }  
      
    @Override  
    protected void paintComponent(Graphics g){  
        super.paintComponent(g);  
          
            Graphics2D graphics2d = (Graphics2D) g.create();  
              
            graphics2d.setComposite(AlphaComposite.SrcOver.
            		derive(transparency));  
              
            graphics2d.setColor(getBackground());  
            graphics2d.fillRect(0, 0, getWidth(), getHeight());  
              
            graphics2d.dispose();  
    }
    
    private class CountDownTimer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (count == 1) {
				label.setText("«Î…‘∫Û..");
				count = 2;
			} else if (count == 2){
				label.setText("«Î…‘∫Û...");
				count = 3;
			} else if (count == 3){
				label.setText("«Î…‘∫Û.");
				count = 1;
			}
		}
    	
    }
}
