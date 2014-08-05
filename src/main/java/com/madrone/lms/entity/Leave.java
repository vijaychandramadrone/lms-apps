package com.madrone.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leave_")
public class Leave implements Serializable {

	private static final long serialVersionUID = 610166417069777773L;
	
	private String id;
	private String description;
	private float days;
	
	public Leave() {
	}
	
	public Leave(String id, String description, float days) {
		this.id = id;
        this.description = description;
        this.days = days;
    }
	
	

	@Id
	@Column(name = "id", nullable = false)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "days")
	public float getDays() {
		return days;
	}
	
	public void setDays(float days) {
		this.days = days;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob instanceof Leave) {
			Leave l = (Leave) ob;
			
			if(id != null && id.equals(l.id)) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * (id != null ? id.hashCode() : 1);
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Leave {")
		.append("id=%s, ")
		.append("description=%s, ")
		.append("days=%d")
		.append("}");
		
		return String.format(pattern.toString(), id, description, days);
	}
}
