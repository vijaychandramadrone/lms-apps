package com.madrone.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.EmployeeHomeForm;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ManagerHomeForm;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.service.UserService;

@Controller
public class MenuController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeLeaveService empLeaveService;

	@RequestMapping(value = "/employeeHome", method = RequestMethod.GET)
	public String employeeHome(Model model, LeaveForm form) {
		model.addAttribute("EmployeeHomeForm", new EmployeeHomeForm());
		return LMSConstants.EMPLOYEE_HOME_SCR;
	}

	// These functions are used in managerMenu.jsp file
	@RequestMapping(value = "/managerHome", method = RequestMethod.GET)
	public String managerHome(Model model, LeaveForm form) {
		model.addAttribute("ManagerHomeForm", new ManagerHomeForm());
		return LMSConstants.MANAGER_HOME_SCR;
	}
	
	// These functions are used in adminMenu.jsp file
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHomeForm(Model model, LeaveForm form) {
			return LMSConstants.ADMIN_HOME_SCR;
	}

}
