package com.example.entity.respone;

import java.util.List;

public class GroupEntity extends BaseResponeEntity{
	private List<Data> data;
	
	public void setData(List<Data> data) { this.data = data; }
	public List<Data> getData() { return data; }
	
	public static class Data{
		private String group_id;
		private String group_num;
		private String name;
		private String pic;
		
		public void setGroupId(String group_id) { this.group_id = group_id; }
		public String getGroupId() { return group_id; }
		
		public void setGroupNum(String group_num) { this.group_num = group_num; }
		public String getGroupNum() { return group_num; }
		
		public void setName(String name) { this.name = name; }
		public String getName() { return name; }
		
		public void setPic(String pic) { this.pic = pic; }
		public String getPic() { return pic; }
	}
}
