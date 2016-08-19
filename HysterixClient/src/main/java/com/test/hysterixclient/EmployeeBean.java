package com.test.hysterixclient;

public class EmployeeBean {
	private int employeeId;
	private String employeeName;
	private int departmentId;
	private int age;
	private String departName;
	
	public EmployeeBean() {
    }

	
	public EmployeeBean(int eId, String eName, int dId, int age, String dn){
		this.employeeId = eId;
		this.employeeName = eName;
		this.departmentId = dId;
		this.age = age;
		this.departName = dn;
	}
	
	  public String getDepartName() {
		return departName;
	  }


	  public void setDepartName(String departName) {
		 this.departName = departName;
	  }

	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
