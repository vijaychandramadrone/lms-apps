package com.madrone.lms.service.util;

import java.util.Calendar;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.LeaveService;
import com.madrone.lms.service.RoleService;
import com.madrone.lms.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
		"classpath:spring/hibernateContext.xml"})
@Component
public class ServiceTestUtil {
	
	// Spring does not allow Autowiring static fields. Hence as suggested in 
	// few forums, defined setters for these static fields and autowired the
	// setter methods. Also made the class a component for this to work.
	
	private static UserService userService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static RoleService roleService;
	private static LeaveService leaveService;
	private static EmployeeLeaveService employeeLeaveService;
	
	@Autowired
	public void setUserService(UserService userService) {
		ServiceTestUtil.userService = userService;
	}
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		ServiceTestUtil.employeeService = employeeService;
	}
	
	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		ServiceTestUtil.departmentService = departmentService;
	}
	
	@Autowired
	public void setRoleService(RoleService roleService) {
		ServiceTestUtil.roleService = roleService;
	}
	
	@Autowired
	public void setLeaveService(LeaveService leaveService) {
		ServiceTestUtil.leaveService = leaveService;
	}
	
	@Autowired
	public void setemployeeLeaveService(
			EmployeeLeaveService employeeLeaveService) {
		ServiceTestUtil.employeeLeaveService = employeeLeaveService;
	}
	
	private ServiceTestUtil() {
	}

	public static User createUser(String empId, String deptId, String roleId, 
			String primaryEmail) {
		User u = userService.findByUserName(primaryEmail);
		if(u == null) {

			Employee e = createEmployee(empId, deptId, roleId, primaryEmail);

			u = new User(primaryEmail, "password");
			u.setEmployee(e);
			userService.saveUser(u);
		}
		return u;
	}

	public static Employee createEmployee(String empId, String deptId, 
			String roleId, String primaryEmail) {

		Employee e = employeeService.findById(empId);
		if(e == null) {
			e = new Employee(empId, "tom", "jerry", primaryEmail, null, 
					Calendar.getInstance(), DesignationEnum.SSE, 
					"#25 Chitrakulam north st", "Mylapore", "Chennai", 
					"TN", 600004,"0000000000");
			Department d = createDepartment(deptId, null);
			e.setDepartment(d);
			
			Role r = createRole(roleId, null);
			e.setRole(r);
			
			employeeService.saveEmployee(e);
		}
		return e;
	}

	public static Department createDepartment(String deptId, String desc) {
		Department d = departmentService.findById(deptId);
		if(d == null) {
			d = new Department(deptId, desc != null ? desc : "test");
			departmentService.saveDepartment(d);
		}
		return d;
	}
	
	public static Role createRole(String roleId, String desc) {
		Role r = roleService.findById(roleId);
		if(r == null) {
			r = new Role(roleId, desc != null ? desc : "test",1);
			roleService.saveRole(r);
		}
		return r;
	}

	public static Leave createLeave(String leaveId, String desc, int days) {	
		Leave l = leaveService.findById(leaveId);
		if(l == null) {
			l = new Leave(leaveId, desc != null ? desc : "test", days);
			leaveService.saveLeave(l);
		}
		return l;
	}

	public static EmployeeLeave createEmployeeLeave(String empId, String deptId, 
			String roleId, String primaryEmail, String leaveId) {
		
		Employee e = createEmployee(empId, deptId, roleId, primaryEmail);
		Leave l = createLeave(leaveId, "test", 10);
		Calendar fromDate = Calendar.getInstance();
		fromDate.add(Calendar.DAY_OF_MONTH, 5);
		Calendar toDate = Calendar.getInstance();
		toDate.add(Calendar.DAY_OF_MONTH, 7);
		EmployeeLeave el = new EmployeeLeave(e, l, fromDate, toDate,5,"AM","PM");
		
		employeeLeaveService.saveEmployeeLeave(el);
		
		return el;
	}

	public static void deleteUser(String userName) {
		
		User user = userService.findByUserName(userName);
		if(user != null) {
			userService.deleteUser(userName);			
		}
	}
	
	public static void deleteEmployee(Employee e) {
		if(e != null) {
			// delete dependent entities first
			// the below line deletes empLeaves as well, since it is cascaded
			// to employee
			e = employeeService.findById(e.getId()); 
			User u = userService.findByUserName(e.getPrimaryEmail());
			if(u != null) {
				userService.deleteUser(u.getUserName());
			}
			employeeService.deleteEmployee(e.getId());	
		}
	}

	public static void deleteEmployee(String employeeId) {
		
		Employee e = employeeService.findById(employeeId);
		deleteEmployee(e);
	}

	public static void deleteDepartment(String deptId) {
		Department d = departmentService.findByIdWithEmployees(deptId);
		if(d != null) {
			// delete dependent entities first
			Set<Employee> employees = d.getEmployees();
			for(Employee e : employees) {
				deleteEmployee(e);
			}
			departmentService.deleteDepartment(d.getId());
		}		
	}
	
	public static void deleteRole(String roleId) {
		Role r = roleService.findByIdWithEmployees(roleId);
		if(r != null) {
			// delete dependent entities first
			Set<Employee> employees = r.getEmployees();
			for(Employee e : employees) {
				deleteEmployee(e);
			}
			roleService.deleteRole(r.getId());
		}		
	}

}
