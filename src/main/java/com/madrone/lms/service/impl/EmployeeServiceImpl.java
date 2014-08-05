package com.madrone.lms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.dao.EmployeeDao;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.Role;
import com.madrone.lms.form.ReportingPerson;
import com.madrone.lms.service.EmployeeService;

@Service("employeeService")
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public Employee findById(String id) {
		return empDao.findById(id);
	}
	
	@Override
	public Employee findByIdWithLeaves(String id) {
		return empDao.findByIdWithLeaves(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveEmployee(Employee e) {
		empDao.saveEmployee(e);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteEmployee(String id) {
		Employee e = empDao.findById(id);
		empDao.delete(e);		
	}

	@Override
	public Employee findByEmailAddress(String primaryEmail) {
		Employee emp = empDao.findByEmailAddress(primaryEmail);                
        emp = setReportingPerson(emp);
        return emp;
	}

	@Override
	public Employee findByEmailAddressWithLeaves(String primaryEmail) {
		return empDao.findByEmailAddressWithLeaves(primaryEmail);
	}

	@Override
	public String findMenuOption(String userName) {
		return empDao.findRole(userName).toLowerCase();
	}
	
	private Employee setReportingPerson(Employee emp) {
        Employee manager = empDao.findById(emp.getReporting_to());
        emp.setReporting_to(manager.getFirstName()+ " " + manager.getLastName());
        return emp;
    }
	
	public String reportingPersonEmail(String empid){
        Employee emp = empDao.findById(empid);
        return getReportingEmail(emp.getReporting_to());
    }
	
	private String getReportingEmail(String empId) {
        Employee manager = empDao.findById(empId);
        return manager.getPrimaryEmail();
   }

	@Override
	public List<ReportingPerson> FindHigherRoles(List<Role> roleListHigher) {
		List<ReportingPerson> reportingList = new ArrayList<ReportingPerson>();
		List<Employee> empList = empDao.FindHigherRoles(roleListHigher);
		
		for(Employee e:empList) {
			ReportingPerson bean = new ReportingPerson();
			bean.setEmpId(e.getId());
			bean.setEmpName(e.getFirstName() + " " + e.getLastName());
			reportingList.add(bean);
		}
		
		return reportingList;
	}

	@Override
	public String findMaxEmpId() {
		Employee emp= empDao.FindMaxEmployeeNumber();
		return emp.getId();
	}
}
