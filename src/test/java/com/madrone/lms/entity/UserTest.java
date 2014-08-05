package com.madrone.lms.entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void testEquality() {
		
		User u1 = new User("peter.e@madronesoft.com", "x");
		User u2 = new User("peter.e@madronesoft.com", "x");
		
		assertEquals(u1, u2);
		assertEquals(u2, u1);
	}
	
	@Test
	public void testToString() {
		
		User u = new User("peter.e@madronesoft.com", "x");
		
		StringBuilder expected = new StringBuilder("User {")
		.append("id=0, ")
		.append("userName=peter.e@madronesoft.com, ")
		.append("createdDate=" + u.getCreatedDate() + ", ")
		.append("modifiedDate=" + u.getModifiedDate() + ", ")
		.append("lastLoginDate=" + u.getLastLoginDate() + ", ")
		.append("failedLoginAttempts=" + 
					u.getFailedLoginAttempts() + ", ")
		.append("isLockout="+ u.isLockout()+ "}");
		
		assertEquals(expected.toString(), u.toString());
	}
}
