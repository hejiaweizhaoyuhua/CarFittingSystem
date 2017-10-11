package com.example.entity;

import java.awt.List;
import java.util.ArrayList;

public class CarTypeEntity extends BaseEntity{
	private String aaa;
	private String bbb;
	private String ccc;
	private String ddd;
	private ArrayList<String> eee;
	
	public void setAaa(String aaa) { this.aaa = aaa; }
	public String getAaa() { return aaa; }
	
	public void setBbb(String bbb) { this.bbb = bbb; }
	public String getBbb() { return bbb; }
	
	public void setCcc(String ccc) { this.ccc = ccc; }
	public String getCcc() { return ccc; }
	
	public void setDdd(String ddd) { this.ddd = ddd; }
	public String getDdd() { return ddd; }
	
	public void setEee(ArrayList<String> eee) { this.eee = eee; }
	public ArrayList<String> getEee() { return eee; }
}
