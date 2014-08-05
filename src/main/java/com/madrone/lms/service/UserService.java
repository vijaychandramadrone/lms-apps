package com.madrone.lms.service;

import com.madrone.lms.entity.User;
import com.madrone.lms.form.UserForm;

public interface UserService {

	User findById(Long id);
	
	void saveUser(User user);
	
	void deleteUser(String userName);

	User findByUserName(String userName);

	boolean authenticateUser(String userName, String password);

	void saveUserAndEmployee(UserForm userForm, String string);

	UserForm searchUser(String searchEmail);



}
