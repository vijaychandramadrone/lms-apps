package com.madrone.lms.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
"classpath:spring/hibernateContext.xml"})
public class EmailServiceTest {
	
	@Autowired
	private EmailService emailService;
	
	@Test
	public void testSendEmail() {
		String fromEmail = "madronetest@gmail.com";
		String toEmail = "madronetest@gmail.com";
		String subject = "Email test";
		String msg = "Email test .......";
		try {
			emailService.sendMail(fromEmail, toEmail, subject, msg);
		} catch(Exception e) {
			Assert.fail("Failed to send email. " + e.getLocalizedMessage());
		}
	}

}
