package com.example.entity.respone;

import java.util.List;

public class CarCodeAreaEntity extends BaseResponeEntity{
	private List<Data> data;
	
	public void setData(List<Data> data) { this.data = data; }
	public List<Data> getData() { return data; }
	
	public static class Data{
		private String type_id;
		private String car_code;
		private String name;
		private String type;
		private List<Models> models;
		
		public void setTypeId(String type_id) { this.type_id = type_id; }
		public String getTypeId() { return type_id; }
		
		public void setCarCode(String car_code) { this.car_code = car_code; }
		public String getCarCode() { return car_code; }
		
		public void setName(String name) { this.name = name; }
		public String getName() { return name; }
		
		public void setType(String type) { this.type = type; }
		public String getType() { return type; }
		
		public void setModels(List<Models> models) { this.models = models; }
		public List<Models> getModels() { return models; }
		
		public class Models{
			private String model_id;
			private String model;
			
			public void setModelId(String model_id) { this.model_id = model_id; }
			public String getModelId() { return model_id; }
			
			public void setModel(String model) { this.model = model; }
			public String getModel() { return model; }
		}
	}
}
