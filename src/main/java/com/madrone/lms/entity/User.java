package com.madrone.lms.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@SequenceGenerator(
		name="SEQ_STORE",
		sequenceName="user__id_seq"
)
@Table(name = "user_", uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_name")})
public class User implements Serializable {
	
	private static final long serialVersionUID = 5177316647031047346L;
	
	private long id;
	private String userName;
	private String password;
	private Calendar createdDate;
	private Calendar modifiedDate;
	private Calendar lastLoginDate;
	private int failedLoginAttempts;
	private boolean lockout;
	private Employee employee;
	
	public User() {
	}
	
	public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.createdDate = Calendar.getInstance();
        this.modifiedDate = Calendar.getInstance();
        this.failedLoginAttempts = 0;
		this.lockout = false;
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_STORE")
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "user_name", unique = true, nullable = false)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "created_date", nullable = false)
	public Calendar getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "modified_date", nullable = false)
	public Calendar getModifiedDate() {
		return modifiedDate;
	}
	
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@Column(name = "last_login_date")
	public Calendar getLastLoginDate() {
		return lastLoginDate;
	}
	
	public void setLastLoginDate(Calendar lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	@Column(name = "failed_login_attempts", nullable = false)
	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}
	
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}
	
	@Column(name = "lockout")
	public boolean isLockout() {
		return lockout;
	}
	
	public void setLockout(boolean lockout) {
		this.lockout = lockout;
	}
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob instanceof User) {
			User u = (User) ob;
			
			if((id == u.id) && (userName != null && 
					userName.equals(u.userName)) ) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * (userName != null ? userName.hashCode() : 1);
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("User {")
		.append("id=%d, ")
		.append("userName=%s, ")
		.append("createdDate=%s, ")
		.append("modifiedDate=%s, ")
		.append("lastLoginDate=%s, ")
		.append("failedLoginAttempts=%d, ")
		.append("isLockout=%s")
		.append("}");
		
		return String.format(pattern.toString(), 
				id,
				userName, 
				createdDate,
				modifiedDate,
				lastLoginDate,
				failedLoginAttempts,
				lockout
				);
	}

}
