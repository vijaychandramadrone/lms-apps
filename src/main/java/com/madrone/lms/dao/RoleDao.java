package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Role;

public interface RoleDao extends AbstractDao<Role, String> {

	void saveRole(Role d);

	Role findByIdWithEmployees(String id);

	List<Role> getRoleTypes();

	int getLevel(String roleId);

	List<Role> getRoleListHigher(int level);

}
