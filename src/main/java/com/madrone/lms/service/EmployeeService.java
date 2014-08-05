package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.Role;
import com.madrone.lms.form.ReportingPerson;

public interface EmployeeService {

	Employee findById(String id);
	
	Employee findByIdWithLeaves(String id);
	
	void saveEmployee(Employee e);

	void deleteEmployee(String id);
	
	Employee findByEmailAddress(String primaryEmail);
	
	Employee findByEmailAddressWithLeaves(String primaryEmail);

	String findMenuOption(String userName);

	List<ReportingPerson> FindHigherRoles(List<Role> roleListHigher);

	String findMaxEmpId();
	
	String reportingPersonEmail(String id);

}
