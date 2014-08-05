package com.madrone.lms.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.ApprovedLeaveSummaryForm;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ViewLeaveRequestForm;
import com.madrone.lms.service.EmailService;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.LeaveService;
import com.madrone.lms.utils.JSONUtils;
import com.madrone.lms.utils.JsonResponse;
import com.madrone.lms.utils.MailUtils;

@Controller
public class ApproveLeaveController {
	private static final Logger logger = LoggerFactory
			.getLogger(CancelLeaveController.class);

	@Autowired
	private EmployeeLeaveService empLeaveService;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmployeeService empService;
	
	//Show Form for Leave - Approval & Rejection.
	@RequestMapping(value = "/approveLeave", method = RequestMethod.GET)
	public String viewApproveLeave(Model model, ViewLeaveRequestForm form,
			HttpSession session) {
		
		logger.info("Inside ApproveLeave()");
		String userName = (String) session.getAttribute("sessionUser");
		List<LeaveDetailsGrid> leaveListOfTeam = empLeaveService
				.getLeaveListOfTeam(userName,"ALL");
		String jsonString = JSONUtils.convertListToJson(leaveListOfTeam);
		model.addAttribute("jsonString", jsonString);
		model.addAttribute("ViewLeaveRequestForm", new ViewLeaveRequestForm());
		return LMSConstants.MANAGER_VIEW_LEAVE_REQUEST_SCR;
	}
	
	/*Adding this method to show LeaveType grid in ViewLeaveRequest Screen*/
	@RequestMapping(value = "/getLeaveTypeData", method = RequestMethod.POST)
	public @ResponseBody JsonResponse getLeaveTypeData(Model model, ViewLeaveRequestForm form,HttpSession session)  {
		
		 JsonResponse res = new JsonResponse();
		 String empprimaryemail = form.getEmpPrimaryEmail();
         List<ApplyLeaveFormGrid> gridList = leaveService.getApplyLeaveGridDetails(empprimaryemail);
 		 String jsonString= JSONUtils.convertListToJson(gridList);
 		 res.setResult(jsonString);
		 res.setStatus("SUCCESS");
         return res;
	}
	
	//Submit method for Leave - Approval.
	@RequestMapping(value = "/submitViewLeaveRequest1", method = RequestMethod.POST)
	public ModelAndView submitForApprove(@ModelAttribute("viewleavereq") ViewLeaveRequestForm form,
			                        BindingResult result, Map<String, Object> map, HttpSession session,  
			                        RedirectAttributes ra, HttpServletRequest request) {
		
		logger.info("inside submitViewLeaveRequest()");
		ModelAndView modelView = new ModelAndView(new RedirectView(LMSConstants.APPROVE_LEAVE_URL));
		String jsonString1 = form.getSelecteddata();
		LeaveForm approveForm = JSONUtils
				.convertJsonToObjectToClass(jsonString1);
		approveForm.setReason(form.getReason());
		if (approveForm != null) {
			String operation = LMSConstants.LEAVE_APPROVE;
			EmployeeLeave el = empLeaveService.setBeanValuesForSave(approveForm,operation);
			String from 		 = (String) session.getAttribute("sessionUser");
			empLeaveService.approveEmployeeLeave(el);
			Employee employee    = empService.findByEmailAddress(from);
			request.setAttribute("ApproveForm", approveForm);
			request.setAttribute("Employee", employee);
			String mailSubject 	 = MailUtils.composeEmailSubject(request,LMSConstants.LEAVE_APPROVE);
			emailService.sendMail(from,el.getEmployee().getPrimaryEmail(),"Manager’s response ", mailSubject);
			ra. addFlashAttribute("SucessMessage", messageSource.getMessage(
					"lms.approveLeave_success_message", new Object[] { "" },
					Locale.getDefault()));
		}

		return modelView;
	}

	// Submit method for Leave - Rejection
	@RequestMapping(value = "/submitViewLeaveRequest2", method = RequestMethod.POST)
	public ModelAndView submitForReject(@ModelAttribute("viewleavereq") ViewLeaveRequestForm form,
			                      BindingResult result, Map<String, Object> map, HttpSession session,
			                      RedirectAttributes ra, HttpServletRequest request) {
		logger.info("inside submitViewLeaveRequest()");
		ModelAndView modelView = new ModelAndView(new RedirectView(LMSConstants.APPROVE_LEAVE_URL));
		String jsonString1 = form.getSelecteddata();

		LeaveForm approveForm = JSONUtils
				.convertJsonToObjectToClass(jsonString1);
		approveForm.setReason(form.getReason());
		if (approveForm != null) {
			String operation = LMSConstants.LEAVE_APPROVE;
			EmployeeLeave el = empLeaveService.setBeanValuesForSave(approveForm,operation);
			empLeaveService.rejectEmployeeLeave(el);
			String from 		 = (String) session.getAttribute("sessionUser");
			Employee employee    = empService.findByEmailAddress(from);
			request.setAttribute("ApproveForm", approveForm);
			request.setAttribute("Employee", employee);
			String mailSubject 	 = MailUtils.composeEmailSubject(request,LMSConstants.LEAVE_REJECT);
			
			emailService.sendMail(from,el.getEmployee().getPrimaryEmail(),"Manager’s response ", mailSubject);
			ra. addFlashAttribute("SucessMessage", messageSource.getMessage(
					"lms.rejectLeave_success_message", new Object[] { "" },
					Locale.getDefault()));
		}

		return modelView;
	}
}
