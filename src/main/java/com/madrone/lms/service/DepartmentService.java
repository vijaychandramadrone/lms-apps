package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.Department;

public interface DepartmentService {

	Department findById(String id);
	
	Department findByIdWithEmployees(String id);

	void saveDepartment(Department d);

	void deleteDepartment(String id);

	List<Department> getDepartmentList();

	List<Department> getAdminDepartmentList();

}
