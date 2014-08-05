package com.madrone.lms.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
		name="SEQ_STORE",
		sequenceName="employeeleave__id_seq",
		initialValue=1, 
		allocationSize=100
)
@Table(name="employeeleave_")
public class EmployeeLeave implements Serializable {

	private static final long serialVersionUID = 1422177851998196650L;
	
	private long id;
	private Employee employee;
	private Leave leave;
	private Calendar fromDate;
	private Calendar toDate;
	private float noOfDays;
	
	private String fromDateSession;  //This is for setting AM or PM
	private String toDateSession;    //This is for setting AM or PM
	private String reasonForLeave;
	private String emergencyPhoneNumber;
	private String leaveStatus;
	private String cancellationComments;
	private Calendar cancellationDate;
	private Calendar approvalDate;
	private String approvalComments;
	
	public EmployeeLeave() {
	}
	
	public EmployeeLeave(Employee employee, Leave leave, Calendar fromDate,
			Calendar toDate, int noOfDays,String fromDateSession,String toDateSession) {
		
		this.employee = employee;
		this.leave = leave;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.noOfDays = noOfDays;
		this.fromDateSession = fromDateSession;
		this.toDateSession = toDateSession;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_STORE")
	@Column(name = "id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@ManyToOne
	@JoinColumn(name="leave_id")
	public Leave getLeave() {
		return leave;
	}
	
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	
	@Column(name = "from_date", nullable = false)
	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "to_date", nullable = false)
	public Calendar getToDate() {
		return toDate;
	}

	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}
	
	@Column(name = "no_of_days", nullable = false)
	public float getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(float noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Column(name = "from_date_session", nullable = false)
	public String getFromDateSession() {
		return fromDateSession;
	}

	public void setFromDateSession(String fromDateSession) {
		this.fromDateSession = fromDateSession;
	}

	@Column(name = "to_date_session", nullable = false)
	public String getToDateSession() {
		return toDateSession;
	}

	public void setToDateSession(String toDateSession) {
		this.toDateSession = toDateSession;
	}
	
	@Column(name = "reason_for_leave", nullable = true)
	public String getReasonForLeave() {
		return reasonForLeave;
	}

	public void setReasonForLeave(String reasonForLeave) {
		this.reasonForLeave = reasonForLeave;
	}
	
	@Column(name = "emergeny_phone", nullable = true)
	public String getEmergencyPhoneNumber() {
		return emergencyPhoneNumber;
	}

	public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
		this.emergencyPhoneNumber = emergencyPhoneNumber;
	}

	@Column(name = "leave_status", nullable = false)
	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	@Column(name = "cancellation_comments", nullable = true)
	public String getCancellationComments() {
		return cancellationComments;
	}

	public void setCancellationComments(String cancellationComments) {
		this.cancellationComments = cancellationComments;
	}

	@Column(name = "approval_comments", nullable = true)
	public String getApprovalComments() {
		return approvalComments;
	}

	public void setApprovalComments(String approvalComments) {
		this.approvalComments = approvalComments;
	}
	
	@Column(name = "cancellation_date", nullable = true)
	public Calendar getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Calendar cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	@Column(name = "approval_date", nullable = true)
	public Calendar getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Calendar approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob instanceof EmployeeLeave) {
			EmployeeLeave l = (EmployeeLeave) ob;
			// TODO
			if(id == l.id) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31; // TODO
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("EmployeeLeave {")
		.append("id=%d, ")
		.append("}");
		
		return String.format(pattern.toString(), id);
	}	
}
