package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Department;

public interface DepartmentDao extends AbstractDao<Department, String> {

	void saveDepartment(Department d);

	Department findByIdWithEmployees(String id);

	List<Department> getDepartmentList();

}
