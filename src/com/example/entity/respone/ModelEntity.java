package com.example.entity.respone;

import java.util.List;

public class ModelEntity extends BaseResponeEntity{
	private List<Data> data;
	
	public void setData(List<Data> data) { this.data = data; }
	public List<Data> getData() { return data; }
	
	private class Data{
		private String model_id;
		private String car_code;
		private String name;
		private String type;
		
		public void setModelId(String model_id) { this.model_id = model_id; }
		public String getModelId() { return model_id; }
		
		public void setCarCode(String car_code) { this.car_code = car_code; }
		public String getCarCode() { return car_code; }
		
		public void setName(String name) { this.name = name; }
		public String getName() { return name; }
		
		public void setType(String type) { this.type = type; }
		public String getType() { return type; }
	}
}
