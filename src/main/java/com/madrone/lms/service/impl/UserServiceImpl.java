package com.madrone.lms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.dao.EmployeeDao;
import com.madrone.lms.dao.UserDao;
import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.Role;
import com.madrone.lms.entity.User;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.UserService;
import com.madrone.lms.utils.DateUtils;
import com.madrone.lms.utils.EnumUtils;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	@Autowired
	private EmployeeDao empDao;

	@Override
	public User findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		if (user != null) {
			Employee e = empDao.findByEmailAddress(user.getUserName());

			// Temporary code. Shall be removed after binding the HR module
			// with the LMS module.
			// if Employee does not exist, create employee on the fly
			if (e == null) {
				empDao.saveEmployee(user.getEmployee());
			}

			userDao.saveUser(user);
			logger.info("Successfully saved " + user.toString());
		} else {
			throw new IllegalArgumentException("User object passed is null");
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		User user = userDao.findByUserName(userName);
		userDao.deleteByUser(user);
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		return userDao.authenticateUser(userName, password);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUserAndEmployee(UserForm userForm, String action) {

		Employee emp = new Employee(userForm.getNewEmpId(),
				userForm.getFirstname(), userForm.getLastname(),
				userForm.getEmail(), "",
				DateUtils.convertStringToCalendar(userForm.getDateofjoin()),
				EnumUtils.getDesignation(userForm.getDesig()),
				userForm.getAddress(), "", userForm.getCity(),
				userForm.getState(), userForm.getPincode(), userForm.getPhone());

		Department dept = new Department();
		dept.setId(userForm.getDept());
		emp.setDepartment(dept);

		Role role = new Role();
		role.setId(userForm.getRole());
		emp.setRole(role);
		emp.setReporting_to(userForm.getReportingto());
		emp.setSecondaryEmail(userForm.getSecemail());

		User user = new User(userForm.getEmail(), userForm.getPassword());
		user.setEmployee(emp);

		switch (action) {
			case LMSConstants.INSERT: {
				empDao.saveEmployee(emp);
				userDao.saveUser(user);
				break;
			}
			case LMSConstants.UPDATE: {
				user.setUserName(userForm.getEmail());
				user.setId(Long.valueOf(userForm.getUserId()));
				empDao.update(emp);
				userDao.update(user);
				break;
			}
		}
	}

	@Override
	public UserForm searchUser(String searchEmail) {

		Employee emp = empDao.findByEmailAddress(searchEmail);

		UserForm userform = null;
		if (emp == null) {
			return userform;
		} else {
			userform = new UserForm();
			userform.setNewEmpId(emp.getId());
			userform.setFirstname(emp.getFirstName());
			userform.setLastname(emp.getLastName());
			userform.setEmail(emp.getPrimaryEmail());
			userform.setSecemail(emp.getSecondaryEmail());
			userform.setDateofjoin(DateUtils.convertCalendarToString(emp
					.getDateOfJoin()));
			userform.setDept(emp.getDepartment().getId());
			userform.setDesig(emp.getDesignation().name());
			userform.setReportingto(emp.getReporting_to());
			userform.setUserName(emp.getPrimaryEmail());
			userform.setAddress(emp.getAddress().getAddressLine1());
			userform.setState(emp.getAddress().getState());
			userform.setCity(emp.getAddress().getCity());
			userform.setState(emp.getAddress().getState());
			userform.setPincode(emp.getAddress().getZipcode());
			userform.setLevel(emp.getRole().getLevel());
			userform.setRole(emp.getRole().getId());
			System.out.println("Emp Contact Number "+emp.getPhone());
			userform.setPhone(emp.getPhone());

			User user = userDao.findByUserName(searchEmail);
			userform.setPassword(user.getPassword());
			userform.setUserId(String.valueOf(user.getId()));
			return userform;
		}
	}

	

}
