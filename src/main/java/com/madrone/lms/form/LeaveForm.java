package com.madrone.lms.form;

import com.madrone.lms.entity.LeaveStatusEnum;
// This Form common for Apply Leave and Cancel Leave Screens.
public class LeaveForm {
	
	private String empId;
	private String empName;
	
	private String fromDate;
	private String toDate;
	private String fromDateSession;
	private String toDateSession;
	

	private String leaveType;
	private float noOfDays;
	private String reason;
	private String emergencyPhone;

	private LeaveStatusEnum status;
	private String action;
	
	private String selecteddata;
	
	private String screenName;
	
	
	private long id; // This is reffering ID of EmployeeLeave
	
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public LeaveStatusEnum getStatus() {
		return status;
	}
	public void setStatus(LeaveStatusEnum status) {
		this.status = status;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public float getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(float noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getEmergencyPhone() {
		return emergencyPhone;
	}
	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	
	public String getFromDateSession() {
		return fromDateSession;
	}
	public void setFromDateSession(String fromDateSession) {
		this.fromDateSession = fromDateSession;
	}
	public String getToDateSession() {
		return toDateSession;
	}
	public void setToDateSession(String toDateSession) {
		this.toDateSession = toDateSession;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSelecteddata() {
		return selecteddata;
	}
	public void setSelecteddata(String selecteddata) {
		this.selecteddata = selecteddata;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	@Override
	public String toString() {
		return "ApplyLeaveForm [empId=" + empId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}
	
	
	
	
	
}
