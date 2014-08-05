package com.madrone.lms.entity;

public enum LeaveStatusEnum {
	
	P("PENDING_APPROVAL"),
	C("CANCELLED"),
	A("APPROVED"),
	R("REJECTED");
	
	
	private final String description;


	LeaveStatusEnum(String description) {
		this.description = description;
	}
	
	public String description() {
		return description;
	}
	

}
