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
@Table(name = "department_")
public class Department implements Serializable { 

	private static final long serialVersionUID = 2544348370348539183L;
	
	private String id;
	private String description;
	private Set<Employee> employees = new HashSet<Employee>();
	
	public Department() {
	}
	
	public Department(String id, String description) {
		this.id = id;
        this.description = description;
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
	
	@OneToMany(mappedBy="department")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob instanceof Department) {
			Department d = (Department) ob;
			
			if(id != null && id.equals(d.id)) {
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
				
		StringBuilder pattern = new StringBuilder("Department {")
		.append("id=%s, ")
		.append("description=%s")
		.append("}");
		
		return String.format(pattern.toString(), 
				id,
				description
				);
	}	
}

