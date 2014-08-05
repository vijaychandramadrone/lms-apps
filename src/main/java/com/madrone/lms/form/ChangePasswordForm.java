package com.madrone.lms.form;

public class ChangePasswordForm {
	
	private String userName;
	private String oldPassword;
	private String newPassword;
	private String confirmNewPasswod;
	
	private String empName;
	
	/*public ChangePasswordForm(String userName) {
		this.userName = userName;
	}*/
	
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
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmNewPasswod() {
		return confirmNewPasswod;
	}
	public void setConfirmNewPasswod(String confirmNewPasswod) {
		this.confirmNewPasswod = confirmNewPasswod;
	}

	
	
}
