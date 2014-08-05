package com.madrone.lms.service;

public interface EmailService {

	void sendMail(String from, String to, String subject, String msg);

}
