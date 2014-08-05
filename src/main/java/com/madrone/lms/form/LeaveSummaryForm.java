package com.madrone.lms.form;

public class LeaveSummaryForm {
	
	private String empName;
	private String userName;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "LeaveSummaryForm [empName=" + empName + ", userName="
				+ userName + "]";
	}
	

}
