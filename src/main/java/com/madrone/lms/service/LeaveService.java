package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.Leave;
import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.LeaveTypeForm;

public interface LeaveService {
	
	Leave findById(String id);

	void saveLeave(Leave l);

	void deleteLeave(String id);

	List<Leave> getLeaveTypes();

	List<ApplyLeaveFormGrid> getApplyLeaveGridDetails(String userName);

	void updateLeave(Leave l);

	Leave setBeanValuesForSave(LeaveTypeForm form);

	List<Leave> getAdminLeaveTypes();



}