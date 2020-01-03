package com.struts2.springsecurity4.tiles.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	
	private String proName;
	private String proDetail;
	private String proType;
	private String proAdd;
	
	
	
	


	public String getProName() {
		return proName;
	}






	public void setProName(String proName) {
		this.proName = proName;
	}






	public String getProDetail() {
		return proDetail;
	}






	public void setProDetail(String proDetail) {
		this.proDetail = proDetail;
	}






	public String getProType() {
		return proType;
	}






	public void setProType(String proType) {
		this.proType = proType;
	}






	public String getProAdd() {
		return proAdd;
	}






	public void setProAdd(String proAdd) {
		this.proAdd = proAdd;
	}






	public String execute()
	{
		
		return SUCCESS;
	}
}
