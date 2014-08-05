package com.madrone.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ViewLeaveRequestForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class ApprovedRejectedListController {
	@Autowired
	private EmployeeLeaveService empLeaveService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ApprovedRejectedListController.class);
	
	// Show Form for Summary : Approval List
	@RequestMapping(value = "/approvalList", method = RequestMethod.GET)
	public String viewApprovedleaves(Model model, LeaveForm form,
			HttpSession session) {

		logger.info("Inside ApproveLeaveSummary()");
		String userName = (String) session.getAttribute("sessionUser");
		List<LeaveDetailsGrid> leaveListOfTeam = empLeaveService
				.getLeaveListOfTeam(userName, LMSConstants.LEAVE_STATUS_APPROVE);
		String jsonString = JSONUtils.convertListToJson(leaveListOfTeam);
		logger.info("ApprovalList-Json" + jsonString);
		model.addAttribute("jsonString", jsonString);
		model.addAttribute("ViewLeaveRequestForm", new ViewLeaveRequestForm());
		return LMSConstants.MANAGER_VIEW_APPROVED_LEAVES_SCR;
	}

	// Show Form for Summary : Rejection List
	@RequestMapping(value = "/rejetionList", method = RequestMethod.GET)
	public String viewRejectedleaves(Model model, LeaveForm form,
			HttpSession session) {
		logger.info("Inside RejectLeaveSummary()");
		String userName = (String) session.getAttribute("sessionUser");
		List<LeaveDetailsGrid> leaveListOfTeam = empLeaveService
				.getLeaveListOfTeam(userName, LMSConstants.LEAVE_STATUS_REJECT);
		String jsonString = JSONUtils.convertListToJson(leaveListOfTeam);
		
		logger.info("RejectedList-Json" + jsonString);
		model.addAttribute("jsonString", jsonString);
		model.addAttribute("ViewLeaveRequestForm", new ViewLeaveRequestForm());
		return LMSConstants.MANAGER_VIEW_REJECTED_LEAVES_SCR;
	}
	
	// Show Form for Summary : Cancelled List
			@RequestMapping(value = "/cancellationList", method = RequestMethod.GET)
			public String viewCancelledleaves(Model model, LeaveForm form,
					HttpSession session) {

				logger.info("Inside CancelledLeaveSummary()");
				String userName = (String) session.getAttribute("sessionUser");
				List<LeaveDetailsGrid> leaveListOfTeam = empLeaveService
						.getLeaveListOfTeam(userName, LMSConstants.LEAVE_STATUS_CANCEL);
				String jsonString = JSONUtils.convertListToJson(leaveListOfTeam);
				model.addAttribute("jsonString", jsonString);
				model.addAttribute("ViewLeaveRequestForm", new ViewLeaveRequestForm());
				return LMSConstants.MANAGER_VIEW_CANCELLED_LEAVES_SCR;
			}

}
