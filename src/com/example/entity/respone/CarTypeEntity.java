package com.example.entity.respone;

import java.util.List;

public class CarTypeEntity extends BaseResponeEntity{
	private List<Data> data;
	
	public void setData(List<Data> data) { this.data = data; }
	public List<Data> getData() { return data; }
	
	public static class Data{
		private String car_code;
		private String area;
		
		public void setCarCode(String car_code) { this.car_code = car_code; }
		public String getCarCode() { return car_code; }
		
		public void setArea(String area) { this.area = area; }
		public String getArea() { return area; }
	}
}
