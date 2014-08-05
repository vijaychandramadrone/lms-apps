package com.madrone.lms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.madrone.lms.form.LoginForm;
import com.madrone.lms.service.UserService;

public class LoginValidator implements Validator {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> c) {
		return LoginForm.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "lms.login.username.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "lms.login.password.empty");
		
		LoginForm loginForm = (LoginForm) object;
			if(!userService.authenticateUser(loginForm.getUserName(), loginForm.getPassword())) {
				errors.rejectValue("password", "lms.login.username.and.password.notvalid");
		}
		
	}

}
