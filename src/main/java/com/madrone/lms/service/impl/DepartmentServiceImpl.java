package com.madrone.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.dao.DepartmentDao;
import com.madrone.lms.entity.Department;
import com.madrone.lms.service.DepartmentService;

@Service("departmentService")
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public Department findById(String id) {
		return departmentDao.findById(id);
	}

	@Override
	public Department findByIdWithEmployees(String id) {
		return departmentDao.findByIdWithEmployees(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveDepartment(Department d) {
		departmentDao.saveDepartment(d);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteDepartment(String id) {
		Department d = departmentDao.findById(id);
		departmentDao.delete(d);
	}

	@Override
	public List<Department> getDepartmentList() {
		return departmentDao.getDepartmentList();
	}

	@Override
	public List<Department> getAdminDepartmentList() {
		List<Department> deptList = departmentDao.getDepartmentList();
		Department d = new Department();
		d.setId(LMSConstants.DEFAULT_COMBO_BOX_VALUE);
		d.setDescription(LMSConstants.DEFAULT_COMBO_BOX_VALUE);
		deptList.add(d);
		return deptList;
	}

}
