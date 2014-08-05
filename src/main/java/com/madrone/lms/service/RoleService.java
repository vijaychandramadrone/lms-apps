package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.Role;
import com.madrone.lms.form.RoleTypeForm;

public interface RoleService {

	Role findById(String id);

	Role findByIdWithEmployees(String id);
	
	void saveRole(Role d);

	void deleteRole(String id);

	List<RoleTypeForm> getRoleList();

	List<Role> getReportingToList();

	List<Role> getRoleListHigher(int level);

	int getLevel(String roleId);
	
	Role setBeanValuesForSave(RoleTypeForm form);

	void updateLeave(Role d);
}
