package com.test.hysterixclient;

public class DepartmentBean {
	
	public int departmentId;
	public String departmentName;
	
	public DepartmentBean(){
		
	}
	
	public DepartmentBean(int dId, String dName){
		this.departmentId = dId;
		this.departmentName = dName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
