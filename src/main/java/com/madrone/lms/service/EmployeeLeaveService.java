package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.LeaveCorrectionForm;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;

public interface EmployeeLeaveService {

	EmployeeLeave findById(long id);
	
	public EmployeeLeave setBeanValuesForSave(LeaveForm leaveForm,String operation);
	
	void saveEmployeeLeave(EmployeeLeave el);

	void deleteEmployeeLeave(long id);

	List<LeaveDetailsGrid> getPendingLeaveList(String userName);

	List<LeaveDetailsGrid> getLeaveList(String userName);

	List<LeaveDetailsGrid> getLeaveListOfTeam(String userName, String filterBy);

	void cancelEmployeeLeave(EmployeeLeave el);

	void approveEmployeeLeave(EmployeeLeave el);

	void rejectEmployeeLeave(EmployeeLeave el);

	List<LeaveDetailsGrid> getPendingAndApprovalLeaveList(String userName);

	List<LeaveDetailsGrid> getLeaveListForAdmin(LeaveCorrectionForm lForm);


	
}
