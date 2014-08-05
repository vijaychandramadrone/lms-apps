package com.madrone.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveSummaryForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.service.LeaveService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class LeaveSummaryController {

	@Autowired
	private EmployeeLeaveService empLeaveService;

	@Autowired
	private LeaveService leaveService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/leaveSummary", method = RequestMethod.GET)
	public String leaveSummary(Model model, LeaveSummaryForm form,
			HttpSession session) {
		String userName = (String) session.getAttribute("sessionUser");

		List<ApplyLeaveFormGrid> LeaveBalanceList = leaveService
				.getApplyLeaveGridDetails(userName);
		List<LeaveDetailsGrid> leaveList = empLeaveService.getLeaveList(userName);

		String jsonString1 = JSONUtils.convertListToJson(LeaveBalanceList);
		String jsonString2 = JSONUtils.convertListToJson(leaveList);
		
		model.addAttribute("jsonString1", jsonString1);
		model.addAttribute("jsonString2", jsonString2);

		model.addAttribute("LeaveSummaryForm", new LeaveSummaryForm());
		return LMSConstants.LEAVE_SUMMARY_SCR+"_" +  
			session.getAttribute("sessionRole");
	}

	// To Show Values in the First Grid.

}
