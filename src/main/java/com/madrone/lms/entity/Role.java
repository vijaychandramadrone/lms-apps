package com.madrone.lms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role_")
public class Role implements Serializable {

	private static final long serialVersionUID = 4878816352778186040L;
	
	private String id;
	private String description;
	private int level;
	
	

	private Set<Employee> employees = new HashSet<Employee>();
	
	public Role() {		
	}
	
	public Role(String id, String description,int level) {
		this.id = id;
		this.description = description;
		this.level = level;
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
	
	@Column(name = "level")
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
		
	@OneToMany(mappedBy="role")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob instanceof Role) {
			Role r = (Role) ob;
			
			if(id != null && id.equals(r.id)) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * ((id != null ? id.hashCode() : 1));
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Role {")
		.append("id=%s, ")
		.append("description=%s")
		.append("}");
		
		return String.format(pattern.toString(), 
				id,
				description
				);
	}
}
