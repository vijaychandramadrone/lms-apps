package com.madrone.lms.service;

import org.hibernate.LazyInitializationException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.service.util.ServiceTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
		"classpath:spring/hibernateContext.xml"})
public class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;

	private final String ROLE_R1 = "r1";
	private final String DEPT_D1 = "d1";
	private final String EMP_100 = "100";
	private final String LEAVE_CL = "CL";
	private final String USER_NAME = "tom@jerry.com";

    @After
    public void tearDown() throws Exception {
    	ServiceTestUtil.deleteEmployee(EMP_100);
    	ServiceTestUtil.deleteDepartment(DEPT_D1);
    }
    
    @Test
    public void testFindById() {
    	Employee e = createEmployee();
    	Employee f = employeeService.findById(EMP_100);
        assertEquals(e, f);        
        
        try {
        	f.getEmployeeLeaves().size();
        	fail("Should not reach here...");
        } catch(LazyInitializationException ex) {        	
        }
    }    

    @Test
    public void testFindByIdWithLeaves() {
    	Employee e = createEmployee();
    	createEmployeeLeave();   
    	Employee f = employeeService.findByIdWithLeaves(EMP_100);
        assertEquals(e, f);
        assertNotNull(f.getEmployeeLeaves());
        assertTrue(f.getEmployeeLeaves().size() == 1);
    }
    
    @Test
    public void testFindByEmailAddress() {
    	Employee e = createEmployee();
    	Employee f = employeeService.findByEmailAddress(USER_NAME);
        assertEquals(e, f);
        
        try {
        	f.getEmployeeLeaves().size();
        	fail("Should not reach here...");
        } catch(LazyInitializationException ex) {        	
        }
    }
    
    @Test
    public void testFindByEmailAddressWithLeaves() {
    	Employee e = createEmployee();
    	createEmployeeLeave();
    	Employee f = employeeService.findByEmailAddressWithLeaves(USER_NAME);
        assertEquals(e, f);
        assertNotNull(f.getEmployeeLeaves());
        assertTrue(f.getEmployeeLeaves().size() == 1);
    }
    
    @Test
    public void testSaveEmployee() throws Exception {
        Employee e = createEmployee();
        Employee found = employeeService.findById(EMP_100);
        assertEquals(e, found);
    }

    @Test
    public void testDeleteEmployee() throws Exception {
    	createEmployee();
        assertNotNull(employeeService.findById(EMP_100));
        // Automatically deletes EmployeeLeaves associated to this Employee, 
        // since they are cascaded
        employeeService.deleteEmployee(EMP_100);
        assertNull(employeeService.findById(EMP_100));
    }

    @Test
    public void testUpdateEmployee() throws Exception {
    	
    	Employee e = createEmployee();
        assertNotNull(e.getDepartment());
        assertEquals(DEPT_D1, e.getDepartment().getId());

        Department d2 = new Department("d2", "department 2");
        departmentService.saveDepartment(d2);
        
        e.setDepartment(d2);
        employeeService.saveEmployee(e);
        
        e = employeeService.findById(EMP_100);
        assertNotNull(e.getDepartment());
        assertEquals(d2.getId(), e.getDepartment().getId());
    }
    
    private Employee createEmployee() {
    	return ServiceTestUtil.createEmployee(EMP_100, DEPT_D1, 
    			ROLE_R1, USER_NAME);
    }
    
    private EmployeeLeave createEmployeeLeave() {
    	return ServiceTestUtil.createEmployeeLeave(EMP_100, DEPT_D1, 
    			ROLE_R1, USER_NAME, LEAVE_CL);
    }
}