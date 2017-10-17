package com.example.jpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import okhttp3.Call;

import com.example.callback.NetCallback;
import com.example.constants.URLConstans;
import com.example.entity.respone.CarCodeAreaEntity;
import com.example.entity.respone.GroupEntity;
import com.example.entity.respone.SGroupEntity;
import com.example.network.OkHttpUtils;
import com.example.utils.JsonUtils;

public class QueryFirstPanel extends BaseJPanel{
	private JLabel carTypeChildLabel;
	private JList<String> carTypeChildList; // 车款列表
	private JScrollPane carTypeChildScrollPane;
	
	private JLabel yearTypeLabel;
	private JList<String> yearTypeList; // 年份列表
	private JScrollPane yearTypeScrollPane;
	
	private JLabel fittingsTypeLabel;
	private JList<String> fittingsTypeList; // 配件种类列表
	private JScrollPane fittingsTypeScrollPane;
	
	private JLabel fittingsLabel;
	private JList<String> fittingsList; // 配件列表
	private JScrollPane fittingsScrollPane;
	private JLabel fittingPicture;
	
	private List<CarCodeAreaEntity.Data> carCodeAreaData;
	private DefaultListModel<String> carCodeAreaModel;
	private List<GroupEntity.Data> fittingsTypeDatas;
	private DefaultListModel<String> fittingsTypeModel;
	private List<SGroupEntity.Data> fittingsDatas;
	private DefaultListModel<String> fittingsModel;
	
	private CarTypeSelection carTypeSelection;
	private YearTypeSelection yearTypeSelection;
	private FittingsTypeSelection fittingsTypeSelection;
	
	public QueryFirstPanel(int LocationX, int LocationY, int width, 
			int height, LayoutManager manager) {
		super(LocationX, LocationY, width, height, manager);
	}
	
	@Override
	public void showUI() {
		prepareCarTypeChild();
		prepareYearType();
		prepareFittingsType();
		prepareFittings();
//		prepareFittingsList();
		prepareFittingPicure();
	}
	
	private void prepareCarTypeChild(){
		carTypeChildLabel = new JLabel("汽车分类", JLabel.CENTER);
		carTypeChildLabel.setFont(new Font("微软斜黑", 0, 13));
		carTypeChildLabel.setLocation(30 + (200 / 2 - 50), 5);
		carTypeChildLabel.setSize(100, 20);
		
		add(carTypeChildLabel);
		
		carTypeChildList = new JList<>();
		carTypeChildList.setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		carTypeChildList.setFont(new Font("微软斜黑", 0, 12));
		
		carTypeChildScrollPane = new JScrollPane(carTypeChildList);
		carTypeChildScrollPane.setLocation(30, 25);
		carTypeChildScrollPane.setSize(220, 270);
		carTypeChildScrollPane.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		carTypeSelection = new CarTypeSelection();
		carTypeChildList.addListSelectionListener(carTypeSelection);
		
		add(carTypeChildScrollPane);
	}
	
	/**
	 * 根据车code和地区获取对应地区的车列表数据
	 * @param car_code
	 * @param audi
	 */
	private void getCarCodeAreaData(String car_code, String area){
		HashMap<String, String> map = new HashMap<>();
		map.put("type", "list");
		map.put("car_code", car_code);
		map.put("area", area);
		OkHttpUtils.get(URLConstans.URL_CAR_CODE_AREA, map, new NetCallback() {
			
			@Override
			public void onResponseSuccess(String result) {
				CarCodeAreaEntity entity = JsonUtils.formJson(result, 
						CarCodeAreaEntity.class);
				if (entity != null && entity.getData() != null) {
					carCodeAreaData = entity.getData();
				}
				
				DefaultListModel<String> model = new DefaultListModel<>();
				for (int i = 0; i < carCodeAreaData.size(); i++) {
					model.addElement(carCodeAreaData.get(i).getName());
				}
				carTypeChildList.setModel(model);
			}
			
			@Override
			public void onResponseFail(String result, String failReason) {
				System.out.println("fail--->result" + result);
				System.out.println("failReason=" + failReason);
			}
			
			@Override
			public void onFail(Call arg0, IOException arg1) {
				
			}
		});
	}
	
	private void prepareYearType(){
		yearTypeLabel = new JLabel("年份", JLabel.CENTER);
		yearTypeLabel.setFont(new Font("微软斜黑", 0, 13));
		yearTypeLabel.setLocation(270 + (150 / 2 - 50), 5);
		yearTypeLabel.setSize(100, 20);
		
		add(yearTypeLabel);
		
		yearTypeList = new JList<>();
		yearTypeList.setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		yearTypeList.setFont(new Font("微软斜黑", 0, 12));
		
		yearTypeScrollPane = new JScrollPane(yearTypeList);
		yearTypeScrollPane.setLocation(270, 25);
		yearTypeScrollPane.setSize(150, 270);
		yearTypeScrollPane.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		yearTypeSelection = new YearTypeSelection();
		yearTypeList.addListSelectionListener(yearTypeSelection);
		
		add(yearTypeScrollPane);
	}
	
	private void getFittingsTypeData(String model_id){
		HashMap<String, String> map = new HashMap<>();
		map.put("model_id", model_id);
		OkHttpUtils.get(URLConstans.URL_GROUP, map, new NetCallback() {
			
			@Override
			public void onResponseSuccess(String result) {
				GroupEntity entity = JsonUtils.formJson(result, 
						GroupEntity.class);
				if (entity != null && entity.getData() != null) {
					fittingsTypeDatas = entity.getData();
				}
				
				fittingsTypeModel = new DefaultListModel<>();
				for (int i = 0; i < fittingsTypeDatas.size(); i++){
					fittingsTypeModel.addElement(fittingsTypeDatas.
							get(i).getName());
				}
				fittingsTypeList.setModel(fittingsTypeModel);
			}
			
			@Override
			public void onResponseFail(String result, String failReason) {
				System.out.println("fail--->result" + result);
				System.out.println("failReason=" + failReason);
			}
			
			@Override
			public void onFail(Call arg0, IOException arg1) {
				
			}
		});
	}
	
	private void prepareFittingsType(){
		fittingsTypeLabel = new JLabel("配件分类", JLabel.CENTER);
		fittingsTypeLabel.setFont(new Font("微软斜黑", 0, 13));
		fittingsTypeLabel.setLocation(440 + (150 / 2 - 50), 5);
		fittingsTypeLabel.setSize(100, 20);
		
		add(fittingsTypeLabel);
		
		fittingsTypeList = new JList<>();
		fittingsTypeList.setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		fittingsTypeList.setFont(new Font("微软斜黑", 0, 12));
		
		fittingsTypeScrollPane = new JScrollPane(fittingsTypeList);
		fittingsTypeScrollPane.setLocation(440, 25);
		fittingsTypeScrollPane.setSize(150, 270);
		fittingsTypeScrollPane.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		fittingsTypeSelection = new FittingsTypeSelection();
		fittingsTypeList.addListSelectionListener(fittingsTypeSelection);
		
		add(fittingsTypeScrollPane);
	}
	
	private void prepareFittings(){
		fittingsLabel = new JLabel("配件", JLabel.CENTER);
		fittingsLabel.setFont(new Font("微软斜黑", 0, 13));
		fittingsLabel.setLocation(610 + (320 / 2 - 50), 5);
		fittingsLabel.setSize(100, 20);
		
		add(fittingsLabel);
		
		fittingsList = new JList<>();
		fittingsList.setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		fittingsList.setFont(new Font("微软斜黑", 0, 12));
		
		fittingsScrollPane = new JScrollPane(fittingsList);
		fittingsScrollPane.setLocation(610, 25);
		fittingsScrollPane.setSize(320, 270);
		fittingsScrollPane.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		
		add(fittingsScrollPane);
	}
	
	private void getFittingsData(String group_id){
		HashMap<String, String> map = new HashMap<>();
		map.put("group_id", group_id);
		OkHttpUtils.get(URLConstans.URL_SGROUP, map, new NetCallback() {
			
			@Override
			public void onResponseSuccess(String result) {
				SGroupEntity entity = JsonUtils.formJson(result, 
						SGroupEntity.class);
				if (entity != null && entity.getData() != null) {
					fittingsDatas = entity.getData();
				}
				
				fittingsModel = new DefaultListModel<>();
				for(int i = 0; i < fittingsDatas.size(); i++){
					fittingsModel.addElement(fittingsDatas.get(i).getName());
				}
				fittingsList.setModel(fittingsModel);
			}
			
			@Override
			public void onResponseFail(String result, String failReason) {
				System.out.println("fail--->result" + result);
				System.out.println("failReason=" + failReason);
			}
			
			@Override
			public void onFail(Call arg0, IOException arg1) {
				
			}
		});
	}
	
//	private void prepareFittingsList(){
//		fittingsLabel = new JLabel("配件", JLabel.CENTER);
//		fittingsLabel.setFont(new Font("微软斜黑", 0, 13));
//		fittingsLabel.setLocation(30 + (680 / 2 - 50), 300);
//		fittingsLabel.setSize(100, 20);
//		
//		add(fittingsLabel);
//		
//		fittingsList = new JList<>();
//		fittingsList.setSelectionMode(
//				ListSelectionModel.SINGLE_SELECTION);
//		fittingsList.setFont(new Font("微软斜黑", 0, 12));
//		
//		fittingsScrollPane = new JScrollPane(fittingsList);
//		fittingsScrollPane.setLocation(30, 320);
//		fittingsScrollPane.setSize(680, 270);
//		fittingsScrollPane.setBorder(BorderFactory.createLineBorder(
//				Color.BLACK, 1));
//		
//		add(fittingsScrollPane);
//	}
	
	private void prepareFittingPicure(){
		fittingPicture = new JLabel();
		fittingPicture.setSize(500, 500);
		// 居中
		fittingPicture.setLocation(750 + (getWidth() - 750) / 2 - 250, 
				getHeight() / 2 - 250);
		fittingPicture.setOpaque(true);
		fittingPicture.setBackground(Color.WHITE);
		fittingPicture.setBorder(BorderFactory.createLineBorder(
				Color.BLACK, 1));
		fittingPicture.setVisible(false);
		
		add(fittingPicture);
	}
	
	/**
	 * 清掉第三个List的数据
	 */
	private void cleanData3(){
		if (fittingsTypeModel != null) {
			fittingsTypeModel.removeAllElements();
		}
	}
	
	/**
	 * 清掉第四个List的数据
	 */
	private void cleanData4(){
		if (fittingsModel != null) {
			fittingsModel.removeAllElements();
		}
	}
	
	private void removeListener(int count){
		if (count == 2){
			yearTypeList.removeListSelectionListener(yearTypeSelection);
			fittingsTypeList.removeListSelectionListener(fittingsTypeSelection);
		} else if (count == 1) {
			fittingsTypeList.removeListSelectionListener(fittingsTypeSelection);
		}
	}
	
	private void setListener(int count){
		if (count == 2){
			yearTypeList.addListSelectionListener(yearTypeSelection);
			fittingsTypeList.addListSelectionListener(fittingsTypeSelection);
		} else if (count == 1) {
			fittingsTypeList.addListSelectionListener(fittingsTypeSelection);
		}
	}
	
	public void setCarCodeAndAudi(String car_code, String audi){
		getCarCodeAreaData(car_code, audi);
	}
	
	private class CarTypeSelection implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				System.out.println("CarTypeSelection-->first-->" + e.getFirstIndex());
				System.out.println("CarTypeSelection-->last-->" + e.getLastIndex());
				
				removeListener(2);
				
				carCodeAreaModel = new DefaultListModel<>();
				int count = e.getLastIndex();
				for (int i = 0; i < carCodeAreaData.get(count).
						getModels().size(); i++){
					carCodeAreaModel.addElement(carCodeAreaData.
							get(count).getModels().get(i).getModel());
				}
				yearTypeList.setModel(carCodeAreaModel);
				
				cleanData3();
				cleanData4();
				
				setListener(2);
			}
		}
	}
	
	private class YearTypeSelection implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				removeListener(1);
				
				int carTypeCount = carTypeChildList.getSelectedIndex();
				int yearTypeCount = e.getLastIndex();
				getFittingsTypeData(carCodeAreaData.get(carTypeCount).
						getModels().get(yearTypeCount).getModelId());
				
				cleanData4();
				setListener(1);
			}
		}
	}
	
	private class FittingsTypeSelection implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				int count = e.getLastIndex();
				
				getFittingsData(fittingsTypeDatas.get(count).
						getGroupId());
			}
		}
	}
}
