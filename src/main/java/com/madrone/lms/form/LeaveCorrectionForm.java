package com.madrone.lms.form;

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Leave;
import com.madrone.lms.entity.LeaveStatusEnum;

public class LeaveCorrectionForm {
	//Simple form fields
	private String deptId;
	private String deptDesc;
	
	private Department Dept;
	private Leave leaveTypes;
	private Leave leaveDates;
	
	
	//Grid Fields.
	private String empId;
	private String empName;
	private String fromDate;
	private String toDate;
	private String fromDateSession;
	private String toDateSession;
	

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public LeaveStatusEnum getStatus() {
		return status;
	}
	public void setStatus(LeaveStatusEnum status) {
		this.status = status;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	private String leaveType;
	private float noOfDays;
	private String reason;
	private String emergencyPhone;

	private LeaveStatusEnum status;
	private String action;
	
	private String selecteddata;
	
	
	public String getSelecteddata() {
		return selecteddata;
	}
	public void setSelecteddata(String selecteddata) {
		this.selecteddata = selecteddata;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public Department getDept() {
		return Dept;
	}
	public void setDept(Department dept) {
		Dept = dept;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public Leave getLeaveTypes() {
		return leaveTypes;
	}
	public void setLeaveTypes(Leave leaveTypes) {
		this.leaveTypes = leaveTypes;
	}
	public Leave getLeaveDates() {
		return leaveDates;
	}
	public void setLeaveDates(Leave leaveDates) {
		this.leaveDates = leaveDates;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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
	

}
