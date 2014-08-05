package com.madrone.lms.entity;

import org.junit.Assert;
import org.junit.Test;

public class LeaveTest {

	@Test
	public void testEquality() {
		
		Leave l1 = new Leave("CL", "Casual Leave", 10);
		Leave l2 = new Leave("CL", "Casual Leave", 10);
		
		Assert.assertEquals(l1, l2);
		Assert.assertEquals(l2, l1);
	}
	
	@Test
	public void testToString() {
		
		Leave l = new Leave("CL", "Casual Leave", 10);
		
		StringBuilder expected = new StringBuilder("Leave {")
		.append("id=CL, ")
		.append("description=Casual Leave, ")
		.append("days=10}");
		
		Assert.assertEquals(expected.toString(), l.toString());
	}
}
