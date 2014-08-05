package com.madrone.lms.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.dao.EmployeeDao;
import com.madrone.lms.dao.EmployeeLeaveDao;
import com.madrone.lms.dao.LeaveDao;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.entity.Leave;
import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.LeaveTypeForm;
import com.madrone.lms.service.LeaveService;
import com.madrone.lms.utils.DateUtils;

@Service("leaveService")
@Transactional(readOnly = true)
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveDao leaveDao;

	@Autowired
	private EmployeeDao empDao;

	@Autowired
	private EmployeeLeaveDao empLeaveDao;

	@Override
	public Leave findById(String id) {
		return leaveDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveLeave(Leave l) {
		leaveDao.save(l);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteLeave(String id) {
		Leave l = leaveDao.findById(id);
		leaveDao.delete(l);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateLeave(Leave l) {
		leaveDao.update(l);

	}

	@Override
	public List<Leave> getLeaveTypes() {
		return leaveDao.getLeaveTypes();
	}

	@Override
	public List<ApplyLeaveFormGrid> getApplyLeaveGridDetails(String primaryemailaddress) {
		List<Leave> leaveList = leaveDao.getLeaveTypes();
		List<ApplyLeaveFormGrid> applyLeaveGrid = 
				new ArrayList<ApplyLeaveFormGrid>();

		for (Leave l : leaveList) {
			ApplyLeaveFormGrid gridBean = new ApplyLeaveFormGrid();
			gridBean.setType(l.getId());

			findEmployeeLeaveBalance(gridBean, primaryemailaddress, l.getDays());
			applyLeaveGrid.add(gridBean);
		}
		return applyLeaveGrid;
	}

	private void findEmployeeLeaveBalance(ApplyLeaveFormGrid gridBean,
			String user, float daysAllotedPerMonth) {
		Employee employee = empDao.findByEmailAddressWithLeaves(user);

		int noOfMonths = 0;
		float totalLeaveTaken = 0.0f;

		Calendar now = Calendar.getInstance();
		Calendar doj = employee.getDateOfJoin();
		Date dateOfJoin = doj.getTime();

		int year = now.get(Calendar.YEAR);
		String firstDay = "01/01/" + String.valueOf(year);
		Date fistDayOfThisYear = DateUtils.convertStringToCalendar(firstDay)
				.getTime();

		if (dateOfJoin.after(fistDayOfThisYear)) {
			noOfMonths = now.get(Calendar.MONTH) - doj.get(Calendar.MONTH);
		} else {
			noOfMonths = now.get(Calendar.MONTH);
		}
		gridBean.setTotal(daysAllotedPerMonth * noOfMonths);

		Set<EmployeeLeave> empLeaveList = employee.getEmployeeLeaves();

		if (empLeaveList.size() > 0) {
			for (EmployeeLeave el : empLeaveList) {
				if (el.getLeave().getId().equals(gridBean.getType())) {
					if (!(el.getLeaveStatus().equals(
							LMSConstants.LEAVE_STATUS_CANCEL) || el
							.getLeaveStatus().equals(
									LMSConstants.LEAVE_STATUS_REJECT))) {
						totalLeaveTaken = totalLeaveTaken + el.getNoOfDays();
					}
				}
			}
		}

		gridBean.setConsumed(totalLeaveTaken);
		gridBean.setBalance(gridBean.getTotal() - totalLeaveTaken);

	}

	@Override
	public Leave setBeanValuesForSave(LeaveTypeForm form) {
		Leave l = new Leave();
		l.setId(form.getId().toUpperCase());
		l.setDescription(form.getDescription());
		l.setDays(form.getDays());
		return l;
	}

	@Override
	public List<Leave> getAdminLeaveTypes() {
		List<Leave> list =  leaveDao.getLeaveTypes();
		Leave l = new Leave();
		l.setId(LMSConstants.DEFAULT_COMBO_BOX_VALUE);
		l.setDescription(LMSConstants.DEFAULT_COMBO_BOX_VALUE);
		list.add(l);
		return list;
	}

}
