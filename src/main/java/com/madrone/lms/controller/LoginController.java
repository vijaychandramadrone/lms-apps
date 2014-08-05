package com.madrone.lms.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.form.LoginForm;

import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.UserService;

@Controller
@SessionAttributes({"EmpForm","userName"})
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		logger.info("Inside showLoginForm()");
		model.addAttribute("LoginForm", new LoginForm());
		return LMSConstants.LOGIN_MENU;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(Model model,
			@ModelAttribute("LoginForm") LoginForm loginForm,
			BindingResult result, Map<String, Object> map, 
			HttpSession session) {

		logger.info("Inside authenticate()");
		String returnString = LMSConstants.LOGIN_MENU;
		boolean validUser = userService.authenticateUser(
				loginForm.getUserName(), loginForm.getPassword());

		if (validUser) {
			returnString = employeeService.findMenuOption(loginForm.getUserName());
			Employee employee = employeeService.findByEmailAddress(loginForm
					.getUserName());
		    
			map.put("userName", loginForm.getUserName());
			map.put("EmpForm",employee);
			session.setAttribute("sessionUser", loginForm.getUserName());
			session.setAttribute("sessionRole",returnString);
			return returnString.toLowerCase();

		} else {
			result.rejectValue("password",
					"lms.login.username.and.password.notvalid");
			return LMSConstants.LOGIN_MENU;

		}

	}
}