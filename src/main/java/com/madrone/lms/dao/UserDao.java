package com.madrone.lms.dao;

import com.madrone.lms.entity.User;

public interface UserDao extends AbstractDao<User, Long> {

	void saveUser(User user);

	User findByUserName(String userName);

	boolean authenticateUser(String userName, String password);

	void deleteByUser(User user);
}
