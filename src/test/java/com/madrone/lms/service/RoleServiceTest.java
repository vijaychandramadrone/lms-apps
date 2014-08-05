package com.madrone.lms.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.lms.entity.DesignationEnum;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.Role;
import com.madrone.lms.service.util.ServiceTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
"classpath:spring/hibernateContext.xml"})
public class RoleServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	private final String ROLE_R1 = "r1";
	private final String DEPT_D1 = "d1";
	private final String EMP_100 = "100";
	private final String USER_NAME = "tom@jerry.com";

	@After
	public void tearDown() throws Exception {
		ServiceTestUtil.deleteEmployee(EMP_100);
		ServiceTestUtil.deleteRole(ROLE_R1);
	}
	
	@Test
	public void testCreateRole() throws Exception {
		/*
		 * Tests non-cascade Employee on creating Role. When updating
		 * role, employee record should not be updated
		 */
		// delete records of last run if exist
		ServiceTestUtil.deleteEmployee(EMP_100);
		ServiceTestUtil.deleteRole(ROLE_R1);
		
		Role r = new Role(ROLE_R1, "role-1",1);
		Employee e = new Employee(EMP_100, "tom", "jerry", USER_NAME, null, 
				Calendar.getInstance(), DesignationEnum.SSE, 
				"#25 Chitrakulam north st", "Mylapore", "Chennai", 
				"TN", 600004,"0000000000");
		Set<Employee> eSet = new HashSet<Employee>();
		eSet.add(e);
		r.setEmployees(eSet);

		roleService.saveRole(r);
		
		r = roleService.findByIdWithEmployees(r.getId());
		assertNotNull(r);
		assertTrue(r.getEmployees().size() == 0);
		
		e = employeeService.findById(e.getId());
		assertNull(e);		
	}
	
	@Test
	public void testUpdateRole() throws Exception {
		/*
		 * Tests non-cascade Employee on updating Role. When updating
		 * role, employee record should not be updated
		 */
		Role r = createRole();
		Employee e = createEmployee();
		assertEquals(DesignationEnum.SSE, e.getDesignation());
		
		r = roleService.findByIdWithEmployees(ROLE_R1);
		assertTrue(r.getEmployees().contains(e));
		
		assertEquals("role_1", r.getDescription());
		r.setDescription("role_1_updated");
		
		e.setDesignation(DesignationEnum.TL);
		
		Set<Employee> eSet = new HashSet<Employee>();
		eSet.add(e);
		r.setEmployees(eSet);
		
		roleService.saveRole(r);
		
		r = roleService.findByIdWithEmployees(ROLE_R1);
		assertEquals("role_1_updated", r.getDescription());
		
		e = employeeService.findById(EMP_100);
		assertEquals(DesignationEnum.SSE, e.getDesignation());		
	}
	

	@Test
	public void testDeleteEmployee() throws Exception {
		Role r = createRole();
		createEmployee();
		Employee e = employeeService.findById(EMP_100);
		assertNotNull(e);
		assertEquals(r, e.getRole());
		employeeService.deleteEmployee(EMP_100);
		assertNull(employeeService.findById(EMP_100));
		
		// Role should be deleted when Employee is deleted
		assertNotNull(roleService.findById(e.getRole().getId()));	
	}	

	@Test
	public void testDeleteRole() throws Exception {
		Role r = createRole();
		createEmployee();
		Employee e = employeeService.findById(EMP_100);
		assertNotNull(e);
		assertEquals(r, e.getRole());
		
		try {
			roleService.deleteRole(r.getId());
			fail("Should not reach here...");
		} catch(DataIntegrityViolationException ex) {			
		}
				
		employeeService.deleteEmployee(e.getId());
		roleService.deleteRole(r.getId());
	}
	
	private Employee createEmployee() {
		return ServiceTestUtil.createEmployee(EMP_100, DEPT_D1, 
				ROLE_R1, USER_NAME);
	}
	
	private Role createRole() {
		return ServiceTestUtil.createRole(ROLE_R1, "role_1");		
	}

}
