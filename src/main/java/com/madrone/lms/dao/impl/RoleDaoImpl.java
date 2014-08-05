package com.madrone.lms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.RoleDao;
import com.madrone.lms.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDaoImpl<Role, String> implements
		RoleDao {

	protected RoleDaoImpl() {
		super(Role.class);
	}

	@Override
	public void saveRole(Role r) {
		save(r);
	}

	@Override
	public Role findByIdWithEmployees(String id) {
		Role r = findById(id);

		if (r != null) {
			Hibernate.initialize(r.getEmployees());
		}

		return r;
	}

	@Override
	public List<Role> getRoleTypes() {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		List<Role> roleTypes = findByCriteria(criterionList);

		return roleTypes;
	}

	@Override
	public int getLevel(String roleId) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.eq("id", roleId));
		List<Role> roleTypes = findByCriteria(criterionList);

		return roleTypes != null ? roleTypes.get(0).getLevel() : 1;
	}

	@Override
	public List<Role> getRoleListHigher(int level) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.gt("level", level));
		List<Role> roleTypes = findByCriteria(criterionList);

		if (roleTypes != null && roleTypes.size() > 0) {
			return roleTypes;
		} else {
			criterionList.clear();
			criterionList.add(Restrictions.eq("level", level));
			roleTypes = findByCriteria(criterionList);

			return roleTypes;

		}
	}

}
