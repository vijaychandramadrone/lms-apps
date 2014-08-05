package com.madrone.lms.service.util;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.DesignationEnum;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.entity.Leave;
import com.madrone.lms.entity.Role;
import com.madrone.lms.entity.User;
import com.madrone.lms.service.DepartmentService;
import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.LeaveService;
import com.madrone.lms.service.RoleService;
import com.madrone.lms.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/hibernateContext.xml","classpath:spring/tiles-def.xml"})
public class NewRecordsTestUtil {
	
	@Autowired
	private EmployeeService  employeeService;
	
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private UserService userService;
	
	private Role role;
	private Department dept;
	private Employee emp;
	private Leave leave;
	private User user;
	private EmployeeLeave empleave;
	
		
		public NewRecordsTestUtil() {
			this.role		= new Role("EMPLOYEE", "EMPLOYEE",1);
			this.dept 		= new Department("DEV", "DEVELOPMENT");
			this.emp 		= new Employee("001", "adminEmployee", "admin", "test@madronesoft.com", null, 
									Calendar.getInstance(), DesignationEnum.AD,
									"#25 Chitrakulam north st", "Mylapore", "Chennai", 
									"TN", 600004, "0000000000");
			this.user 	  	= new User("test@madronesoft.com", "password");
			this.leave 	  	= new Leave("CL", "CASUAL LEAVE",20);
			this.empleave 	= new EmployeeLeave(emp,leave,Calendar.getInstance(),Calendar.getInstance(),1,"AM","PM");
		}
		
			
		
		@Test
		public void testCreateRole() throws Exception {
			Set<Employee> eSet = new HashSet<Employee>();
			eSet.add(emp);
			role.setEmployees(eSet);
			roleService.saveRole(role);
		}
		
		@Test
		public void testCreateDepartment() throws Exception {
			Set<Employee> eSet = new HashSet<Employee>();
			eSet.add(emp);
			dept.setEmployees(eSet);
			departmentService.saveDepartment(dept);
		}
		
		
		@Test
		public void testCreateEmployee() throws Exception {
			Set<EmployeeLeave> eSet = new HashSet<EmployeeLeave>();
			eSet.add(empleave);
			this.emp.setEmployeeLeaves(eSet);
			this.emp.setDepartment(dept);
			this.emp.setRole(role);
			employeeService.saveEmployee(emp);
			
			}
		
		@After
		public void testCreateUser() throws Exception {
			user.setEmployee(emp);
			userService.saveUser(user);
			}
		
		@Test
		public void testCreateLeave() throws Exception{
			leaveService.saveLeave(leave);
		}
		
		
}
