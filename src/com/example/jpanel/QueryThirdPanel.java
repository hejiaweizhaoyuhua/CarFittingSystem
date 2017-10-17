package com.example.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.example.callback.FileDownloadCallback;
import com.example.component.RadiusJButton;
import com.example.network.OkHttpUtils;

public class QueryThirdPanel extends BaseJPanel{
	private JComboBox<String> fittingsCode;
	private RadiusJButton queryButton;
	
	private JLabel carTypeJLabel;
	private JList<String> carTypeResult;
	private JScrollPane carTypesScrollPane;
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
		showPicture();
	}
	
	private void prepareFittingsQuery(){
		fittingsCode = new JComboBox<>();
		fittingsCode.setLocation(20, 10);
		fittingsCode.setSize(150, 25);
		fittingsCode.setFont(new Font("Œ¢»Ì–±∫⁄", 0, 14));
		fittingsCode.setOpaque(true);
		fittingsCode.setEditable(true);
		fittingsCode.setBackground(Color.WHITE);
		
		fittingsCode.addItem("111");
		fittingsCode.addItem("222");
		fittingsCode.addItem("333");
		// …Ë÷√≤ªœ‘ æ»Œ∫Œ÷µ
		fittingsCode.setSelectedIndex(-1);
		// …Ë÷√Ã· æ”Ô
		final JTextField textField = (JTextField) fittingsCode.getEditor().
				getEditorComponent();
		textField.setText(" ≈‰º˛±‡¬Î≤È—Ø");
		textField.setForeground(new Color(200, 200, 200));
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				textField.setText(" ≈‰º˛±‡¬Î≤È—Ø");
				textField.setForeground(new Color(200, 200, 200));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
				textField.setForeground(Color.BLACK);
			}
		});
		
		add(fittingsCode);
		
		queryButton = new RadiusJButton("≤È—Ø");
		queryButton.setSize(70, 25);
		queryButton.setLocation(200, 10);
		queryButton.setFont(new Font("Œ¢»Ì–±∫⁄", 0, 15));
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		add(queryButton);
	}
	
	private void prepareCarTypeResult(){
		carTypeJLabel = new JLabel("≥µ–Õ", JLabel.CENTER);
		carTypeJLabel.setFont(new Font("Œ¢»Ì–±∫⁄", 0, 15));
		carTypeJLabel.setLocation(100 + (250 / 2 - 50), 60);
		carTypeJLabel.setSize(100, 20);
		
		add(carTypeJLabel);
		
		carTypeResult = new JList<>();
		carTypeResult.setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		carTypeResult.setFont(new Font("Œ¢»Ì–±∫⁄", 0, 12));
		
		carTypesScrollPane = new JScrollPane(carTypeResult);
		carTypesScrollPane.setLocation(100, 85);
		carTypesScrollPane.setSize(250, 370);
		carTypesScrollPane.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(carTypesScrollPane);
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
	
	private void showPicture(){
		OkHttpUtils.download("http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201204/20120412123904521.jpg", 
				new FileDownloadCallback() {
			
			@Override
			public void downloadSuccess(String path) {
				showImage(path);
			}
			
			@Override
			public void downloadFail(String error) {
				
			}
		});
	}
	
	private void showImage(final String path){
		ImageIcon icon = new ImageIcon(path);
		icon = new ImageIcon(icon.getImage().
				getScaledInstance(fittingsPicture.getWidth(), 
				fittingsPicture.getHeight(), 
				Image.SCALE_DEFAULT));
		fittingsPicture.setIcon(icon);
	}
}
