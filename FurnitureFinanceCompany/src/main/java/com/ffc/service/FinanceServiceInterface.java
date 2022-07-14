package com.ffc.service;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

import com.ffc.models.Employee;
import com.ffc.models.SendEmail;

public interface FinanceServiceInterface {

	public Employee saveEmployee(Employee employee);

	public void sendEmailWithAttach(SendEmail s, MultipartFile f) throws MessagingException;

}
