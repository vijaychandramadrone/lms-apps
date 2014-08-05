package com.madrone.lms.entity;

public enum DesignationEnum {
	
	SE("Software Engineer"),
	SSE("Senior Software Engineer"),
	TL("Team Leader"),
	STL("Senior Team Leader"),
	AD("Administrator"),
	PM("Project Manager"),
	QA("Quality Assurance");
	
	private final String description;

	public String getDescription() {
		return description;
	}

	DesignationEnum(String description) {
		this.description = description;
	}
	
	public String description() {
		return description;
	}
	
}
