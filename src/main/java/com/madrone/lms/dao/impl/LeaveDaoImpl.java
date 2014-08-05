package com.madrone.lms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.LeaveDao;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.Leave;

@Repository("leaveDao")
public class LeaveDaoImpl extends AbstractDaoImpl<Leave, String>
						implements LeaveDao {

	protected LeaveDaoImpl() {
		super(Leave.class);
	}

	@Override
	public List<Leave> getLeaveTypes() {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		List<Leave> leaveTypes = findByCriteria(criterionList);
		return leaveTypes;
	}

}
