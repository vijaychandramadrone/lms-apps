package com.madrone.lms.form;


public class ViewLeaveRequestForm {

	private String empId;
	private String empName;
	private String fromDate;
	private String fromDateSession;
	private String toDate;
	private String toDateSession;
	private String status;
	private float noOfDays;
	private String selecteddata;
	
	private String leaveType;
	private String leaveReason;
	private String approvalComment;
	private String empPrimaryEmail;
	private String reason;
	
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSelecteddata() {
		return selecteddata;
	}
	public void setSelecteddata(String selecteddata) {
		this.selecteddata = selecteddata;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(float noOfDays) {
		this.noOfDays = noOfDays;
	}
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
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getFromDateSession() {
		return fromDateSession;
	}
	public void setFromDateSession(String fromDateSession) {
		this.fromDateSession = fromDateSession;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getToDateSession() {
		return toDateSession;
	}
	public void setToDateSession(String toDateSession) {
		this.toDateSession = toDateSession;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getApprovalComment() {
		return approvalComment;
	}
	public void setApprovalComment(String approvalComment) {
		this.approvalComment = approvalComment;
	}
	public String getEmpPrimaryEmail() {
		return empPrimaryEmail;
	}
	public void setEmpPrimaryEmail(String empPrimaryEmail) {
		this.empPrimaryEmail = empPrimaryEmail;
	}
	
	
	
}
