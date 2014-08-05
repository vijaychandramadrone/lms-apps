package com.madrone.lms.entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class DepartmentTest {

	@Test
	public void testEquality() {
		
		Department d1 = new Department("dept1", "department-1");
		Department d2 = new Department("dept1", "department-1");
		
		assertEquals(d1, d2);
		assertEquals(d2, d1);
	}
	
	@Test
	public void testToString() {
		
		Department d = new Department("dept", "department");
		
		StringBuilder expected = new StringBuilder("Department {")
		.append("id=dept, ")
		.append("description=department")
		.append("}");
		
		assertEquals(expected.toString(), d.toString());
	}
}