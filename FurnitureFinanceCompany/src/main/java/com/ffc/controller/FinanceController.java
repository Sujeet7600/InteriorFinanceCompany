package com.ffc.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffc.models.Employee;
import com.ffc.models.SendEmail;
import com.ffc.service.FinanceServiceInterface;
import com.google.gson.Gson;
@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class FinanceController {
	@Autowired FinanceServiceInterface fsi;
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@RequestMapping(value="/employee", method = RequestMethod.POST , consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Employee> postEmployee(
			@RequestPart(required = true,value = "photo") MultipartFile photo,
			@RequestPart(required = true,value = "pan") MultipartFile pan,
			@RequestPart(required = true,value = "aadhar") MultipartFile aadhar,
			@RequestPart("employee")String empstring
			) throws IOException   
	{
		Gson g=new Gson();
		Employee employee=g.fromJson(empstring, Employee.class);
		employee.setPhoto(photo.getBytes());			
		employee.setPan(pan.getBytes());
		employee.setAadhar(aadhar.getBytes());
			
		Employee emp=fsi.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	@RequestMapping(value = "/sendAttachment", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE )
	public String sendAttachment(@RequestPart (required = true,value = "attachment") MultipartFile f,
			@RequestPart ("email") String email) throws IOException,MessagingException
	{
		SendEmail s= new SendEmail();
		
		ObjectMapper o= new ObjectMapper();
		
		SendEmail s1= o.readValue(email, SendEmail.class);
		
		s.setFromEmail(fromEmail);
		s.setSubject(s1.getSubject());
		s.setTextBody(s1.getTextBody());
		s.setToEmail(s1.getToEmail());
		fsi.sendEmailWithAttach(s,f);
		
		return "Mail sent With Attachment Successfully...";
		
	}
}
