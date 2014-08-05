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

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.DesignationEnum;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.service.util.ServiceTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
"classpath:spring/hibernateContext.xml"})
public class DepartmentServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	private final String ROLE_R1 = "r1";
	private final String DEPT_D1 = "d1";
	private final String EMP_100 = "100";
	private final String USER_NAME = "tom@jerry.com";

	@After
	public void tearDown() throws Exception {
		ServiceTestUtil.deleteEmployee(EMP_100);
		ServiceTestUtil.deleteDepartment(DEPT_D1);
	}
	
	@Test
	public void testCreateDepartment() throws Exception {
		/*
		 * Tests non-cascade Employee on creating Department. When updating
		 * department, employee record should not be updated
		 */
		// delete records of last run if exist
		ServiceTestUtil.deleteEmployee(EMP_100);
		ServiceTestUtil.deleteDepartment(DEPT_D1);
		
		Department d = new Department(DEPT_D1, "department-1");
		Employee e = new Employee(EMP_100, "tom", "jerry", USER_NAME, null,Calendar.getInstance(), DesignationEnum.SSE,"#25 Chitrakulam north st", "Mylapore", "Chennai","TN", 600004,"000000000");
		Set<Employee> eSet = new HashSet<Employee>();
		eSet.add(e);
		d.setEmployees(eSet);

		departmentService.saveDepartment(d);
		
		d = departmentService.findByIdWithEmployees(d.getId());
		assertNotNull(d);
		assertTrue(d.getEmployees().size() == 0);
		
		e = employeeService.findById(e.getId());
		assertNull(e);		
	}
	
	@Test
	public void testUpdateDepartment() throws Exception {
		/*
		 * Tests non-cascade Employee on updating Department. When updating
		 * department, employee record should not be updated
		 */
		Department d = createDepartment();
		Employee e = createEmployee();
		assertEquals(DesignationEnum.SSE, e.getDesignation());
		
		d = departmentService.findByIdWithEmployees(DEPT_D1);
		assertTrue(d.getEmployees().contains(e));
		
		assertEquals("dept_1", d.getDescription());
		d.setDescription("dept_1_updated");
		
		e.setDesignation(DesignationEnum.TL);
		
		Set<Employee> eSet = new HashSet<Employee>();
		eSet.add(e);
		d.setEmployees(eSet);
		
		departmentService.saveDepartment(d);
		
		d = departmentService.findByIdWithEmployees(DEPT_D1);
		assertEquals("dept_1_updated", d.getDescription());
		
		e = employeeService.findById(EMP_100);
		assertEquals(DesignationEnum.SSE, e.getDesignation());		
	}
	
	@Test
	public void testDeleteEmployee() throws Exception {
		Department d = createDepartment();
		createEmployee();
		Employee e = employeeService.findById(EMP_100);
		assertNotNull(e);
		assertEquals(d, e.getDepartment());
		employeeService.deleteEmployee(EMP_100);
		assertNull(employeeService.findById(EMP_100));
		
		// Department should be deleted when Employee is deleted
		assertNotNull(departmentService.findById(e.getDepartment().getId()));	
	}	

	@Test
	public void testDeleteDepartment() throws Exception {
		Department d = createDepartment();
		createEmployee();
		Employee e = employeeService.findById(EMP_100);
		assertNotNull(e);
		assertEquals(d, e.getDepartment());
		
		try {
			departmentService.deleteDepartment(d.getId());
			fail("Should not reach here...");
		} catch(DataIntegrityViolationException ex) {			
		}
				
		employeeService.deleteEmployee(e.getId());
		departmentService.deleteDepartment(d.getId());
	}
	
	private Employee createEmployee() {
		return ServiceTestUtil.createEmployee(EMP_100, DEPT_D1, 
				ROLE_R1, USER_NAME);
	}
	
	private Department createDepartment() {
		return ServiceTestUtil.createDepartment(DEPT_D1, "dept_1");		
	}

}
