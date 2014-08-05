package com.madrone.lms.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "employee_", uniqueConstraints = {
		@UniqueConstraint(columnNames = "primary_email")})
public class Employee implements Serializable {

	private static final long serialVersionUID = -8774050095045228244L;
	
	private String id;
	private String firstName;
	private String lastName;
	private String primaryEmail;
	private String secondaryEmail;
	private Calendar dateOfJoin;
	private DesignationEnum designation;
	@Embedded private Address address;
	private Department department;
	private Role role;
	private Set<EmployeeLeave> employeeLeaves = new HashSet<EmployeeLeave>();
	private String reporting_to;
	private String phone;
		
	public Employee() {
	}
	

	public Employee(String id, String firstName, String lastName, 
			String primaryEmail, String secondaryEmail, 
			Calendar dateOfJoin, DesignationEnum designation,
			String addressLine1, String addressLine2, String city,
			String state, int zipcode, String phone) {
		this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.dateOfJoin = dateOfJoin;
        this.designation = designation;
        this.address = new Address(addressLine1, addressLine2, city, state, 
        		zipcode);
        this.phone = phone;
    }

	@Id
	@Column(name = "id", nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "primary_email", unique= true, nullable = false)
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	@Column(name = "secondary_email")
	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	
	@Column(name = "date_of_join", nullable = false)
	public Calendar getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Calendar dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	@Column(name = "contact_number", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "designation", nullable = false)
	@Enumerated(EnumType.STRING)
	public DesignationEnum getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationEnum designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
   
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="reporting_to")
    private Employee manager;
	
    public String getReporting_to() {
		return reporting_to;
	}
    

	@OneToMany(mappedBy="manager")
    private Set<Employee> employeeGroup = new HashSet<Employee>();

	public void setReporting_to(String reporting_to) {
		this.reporting_to = reporting_to;
	}
	
	@ManyToOne
    @JoinColumn(name="dept_id")  // TODO: Should I add insertable and updatable false? Need to write tests for this.
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@ManyToOne
    @JoinColumn(name="role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
	public Set<EmployeeLeave> getEmployeeLeaves() {
		return employeeLeaves;
	}

	public void setEmployeeLeaves(Set<EmployeeLeave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob instanceof Employee) {
			Employee e = (Employee) ob;
			
			if((id != null && id.equals(e.id)) && (primaryEmail != null && 
					primaryEmail.equals(e.primaryEmail))) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * ((id != null ? id.hashCode() : 1) + (primaryEmail != null ? 
				primaryEmail.hashCode() : 1));
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Employee {")
		.append("id=%s, ")
		.append("firstName=%s, ")
		.append("lastName=%s, ")
		.append("primaryEmail=%s, ")
		.append("secondaryEmail=%s, ")
		.append("dateOfJoin=%s, ")
		.append("designation=%s, ")
		.append("address=%s")
		.append("}");
		
		return String.format(pattern.toString(), 
				id,
				firstName, 
				lastName,
				primaryEmail,
				secondaryEmail,
				dateOfJoin,
				designation,
				address
				);
	}
}
