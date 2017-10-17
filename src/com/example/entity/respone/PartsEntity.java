package com.example.entity.respone;

import java.util.List;

public class PartsEntity extends BaseResponeEntity{
private List<Data> data;
	
	public void setData(List<Data> data) { this.data = data; }
	public List<Data> getData() { return data; }
	
	private class Data{
		private String pid;
		private String car_code;
		private String remark;
		private String model_name;
		private String tid;
		private String detail;
		private String label;
		private String num;
		private String step;
		private String prices;
		private String model;
		private String quantity;
		
		public void setPid(String pid) { this.pid = pid; }
		public String getPid() { return pid; }
		
		public void setCarCode(String car_code) { this.car_code = car_code; }
		public String getCarcode() { return car_code; }
		
		public void setRemark(String remark) { this.remark = remark; }
		public String getRemark() { return remark; }
		
		public void setModelName(String model_name) { this.model_name = model_name; }
		public String getModelName() { return model_name; }
		
		public void setTid(String tid) { this.tid = tid; }
		public String getTid() { return tid; }
		
		public void setDetail(String detail) { this.detail = detail; }
		public String getDetail() { return detail; }
		
		public void setLabel(String label) { this.label = label; }
		public String getLabel() { return label; }
		
		public void setNum(String num) { this.num = num; }
		public String getNum() { return num; }
		
		public void setStep(String step) { this.step = step; }
		public String getStep() { return step; }
		
		public void setPrices(String prices) { this.prices = prices; }
		public String getPrices() { return prices; }
		
		public void setModel(String model) { this.model = model; }
		public String getModel() { return model; }
		
		public void setQuantity(String quantity) { this.quantity = quantity; }
		public String getQuantity() { return quantity; }
		
	}
}
