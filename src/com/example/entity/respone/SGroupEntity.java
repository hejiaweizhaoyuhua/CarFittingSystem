package com.example.entity.respone;

import java.util.List;

public class SGroupEntity extends BaseResponeEntity{
	private List<Data> data;
	
	public void setData(List<Data> data) { this.data = data; }
	public List<Data> getData() { return data; }
	
	public static class Data{
		private String sgroup_id;
		private String car_code;
		private String name;
		private String model;
		private String pic;
		
		public void setSGroupId(String sgroup_id) { this.sgroup_id = sgroup_id; }
		public String getSGroupId() { return sgroup_id; }
		
		public void setCarCode(String car_code) { this.car_code = car_code; }
		public String getCarCode() { return car_code; }
		
		public void setName(String name) { this.name = name; }
		public String getName() { return name; }
		
		public void setModel(String model) { this.model = model; }
		public String getModel() { return model; }
		
		public void setPic(String pic) { this.pic = pic; }
		public String getPic() { return pic; }
	}
}
