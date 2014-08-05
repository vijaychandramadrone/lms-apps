package com.madrone.lms.service;

import java.util.Calendar;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.lms.entity.User;
import com.madrone.lms.service.util.ServiceTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
		"classpath:spring/hibernateContext.xml"})
public class UserServiceTest {
	
	@Autowired
    private UserService userService;
	
	private final String ROLE_R1 = "r1";
	private final String DEPT_D1 = "d1";
	private final String EMP_100 = "100";
    private final String USER_NAME = "tom@jerry.com";

    @After
    public void tearDown() throws Exception {
    	ServiceTestUtil.deleteUser(USER_NAME);
    	ServiceTestUtil.deleteEmployee(EMP_100);
    	ServiceTestUtil.deleteDepartment(DEPT_D1);
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = createUser();
        User found = userService.findByUserName(user.getUserName());
        assertEquals(user, found);
        assertTrue(user.getFailedLoginAttempts() == 0);
    }

    @Test
    public void testSearchUser() throws Exception {
        User u = createUser();
        u = userService.findByUserName(u.getUserName());
        assertEquals(USER_NAME, u.getUserName());
    }

    @Test
    public void testDeleteUser() throws Exception {
        createUser();
        userService.findByUserName(USER_NAME);
        assertNotNull(userService.findByUserName(USER_NAME));
        userService.deleteUser(USER_NAME);
        assertNull(userService.findByUserName(USER_NAME));
    }

    @Test
    public void testUpdateUser() throws Exception {
    	int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    	
        createUser();
        User u1 = userService.findByUserName(USER_NAME);
        assertNotNull(u1);
        assertEquals(USER_NAME, u1.getUserName());
        Calendar todayDate = u1.getModifiedDate();
        assertTrue(today == todayDate.get(Calendar.DAY_OF_MONTH));

        Calendar tommDate = (Calendar) todayDate.clone();
        tommDate.add(Calendar.DAY_OF_MONTH, 1); 
        int tomm = tommDate.get(Calendar.DAY_OF_MONTH);
        u1.setModifiedDate(tommDate);
        userService.saveUser(u1);

        User found = userService.findByUserName(USER_NAME);
        assertNotNull(found);
        assertEquals(USER_NAME, u1.getUserName());
        tommDate = u1.getModifiedDate();
        assertTrue(tomm == tommDate.get(Calendar.DAY_OF_MONTH));
    }
    
    private User createUser() {
    	return ServiceTestUtil.createUser(EMP_100, DEPT_D1, 
    			ROLE_R1, USER_NAME);
    }
}
