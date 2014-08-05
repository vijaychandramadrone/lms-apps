package com.madrone.lms.entity;

import java.util.Calendar;

import static org.junit.Assert.*;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testEquality() {
		
		Employee e1 = new Employee("100", "tom", "jerry", "t@j.com", null, 
    			Calendar.getInstance(), DesignationEnum.SSE, 
    			"#25 Chitrakulam north st", "Mylapore", "Chennai", 
    			"TN", 600004,"000000000");
		Employee e2 = new Employee("100", "tom", "jerry", "t@j.com", null, 
    			Calendar.getInstance(), DesignationEnum.SSE, 
    			"#25 Chitrakulam north st", "Mylapore", "Chennai", 
    			"TN", 600004,"0000000000");
		
		assertEquals(e1, e2);
		assertEquals(e2, e1);
	}
	
	@Test
	public void testToString() {
		
		Calendar doj = Calendar.getInstance();
		Employee e = new Employee("100", "tom", "jerry", "t@j.com", null, 
				doj, DesignationEnum.SSE, "#25 Chitrakulam north st", 
				"Mylapore", "Chennai", "TN", 600004, "0000000000");
		
		StringBuilder expected = new StringBuilder("Employee {")
		.append("id=100, ")
		.append("firstName=tom, ")
		.append("lastName=jerry, ")
		.append("primaryEmail=t@j.com, ")
		.append("secondaryEmail=null, ")
		.append("dateOfJoin="+doj+", ")
		.append("designation="+DesignationEnum.SSE+", ")
		.append("address=Address {")
			.append("addressLine1=#25 Chitrakulam north st, ")
			.append("addressLine2=Mylapore, ")
			.append("city=Chennai, ")
			.append("state=TN, ")
			.append("zipcode=600004")
		.append("}}");
		
		assertEquals(expected.toString(), e.toString());
	}
}
