package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.Role;
import com.madrone.lms.form.LeaveCorrectionForm;

public interface EmployeeDao extends AbstractDao<Employee, String>{
	
	Employee findByIdWithLeaves(String id);

	Employee findByEmailAddress(String primaryEmail);
	
	Employee findByEmailAddressWithLeaves(String primaryEmail);
	
	void saveEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);

	String findRole(String userName);

	List<Employee> findTeamList(Employee leadEmployee);

	List<Employee> FindHigherRoles(List<Role> roleListHigher);

	List<Employee> getEmployeeList(LeaveCorrectionForm leaveFormFilter);

	Employee FindMaxEmployeeNumber();
	

}
