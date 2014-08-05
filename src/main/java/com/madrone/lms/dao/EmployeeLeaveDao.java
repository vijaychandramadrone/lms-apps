package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.LeaveCorrectionForm;


public interface EmployeeLeaveDao extends AbstractDao<EmployeeLeave, Long> {

	List<EmployeeLeave> findLeaveSummary();

	List<EmployeeLeave> getLeaveList(Employee emp);

	List<EmployeeLeave> getPendingLeaveList(Employee emp);

	List<EmployeeLeave> getApprovalLeaveList(Employee emp);
	
	List<EmployeeLeave> getRejectionLeaveList(Employee emp);
	
	List<EmployeeLeave> getCancellationLeaveList(Employee emp);
	
	List<EmployeeLeave> getPendingAndApprovalList(Employee emp);

	List<EmployeeLeave> getLeaveListForAdmin
		(List<Employee> employeeList, LeaveCorrectionForm leaveForm);
	

}
