package com.madrone.lms.service;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.service.util.ServiceTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
		"classpath:spring/hibernateContext.xml"})
public class EmployeeLeaveServiceTest {

	private final String ROLE_R1 = "r1";
	private final String DEPT_D1 = "d1";
	private final String EMP_100 = "100";
	private final String PRIMARY_EMAIL = "tom@jerry.com";
	private final String LEAVE_CL = "CL";
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeLeaveService employeeLeaveService;
	
    @After
    public void tearDown() throws Exception {
    	ServiceTestUtil.deleteEmployee(EMP_100);	
    }

    @Test
    public void testSaveEmployeeLeave() throws Exception {
		createEmployeeLeave();
        Employee employee = employeeService.findByIdWithLeaves(EMP_100);
        Set<EmployeeLeave> els = employee.getEmployeeLeaves();
        assertNotNull(els);
        assertTrue(els.size() == 1);
    }

    @Test
    public void testDeleteEmployeeLeave() throws Exception {
    	EmployeeLeave el = createEmployeeLeave();
        assertNotNull(employeeLeaveService.findById(el.getId()));
        employeeLeaveService.deleteEmployeeLeave(el.getId());
        
        assertNull(employeeLeaveService.findById(el.getId()));
        assertNotNull(employeeService.findById(EMP_100));
    }
    
    private EmployeeLeave createEmployeeLeave() {
    	return ServiceTestUtil.createEmployeeLeave(EMP_100, DEPT_D1, 
    			ROLE_R1, PRIMARY_EMAIL, LEAVE_CL);
    }
	
}
