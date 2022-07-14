package com.ffc.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ffc.models.Employee;
import com.ffc.models.SendEmail;
import com.ffc.repository.CustomerRepository;
import com.ffc.repository.EmiStatusRepository;
import com.ffc.repository.EmployeeRepository;
import com.ffc.repository.LoanRepository;
import com.ffc.repository.RemarkRepository;

@Service
public class FinanceServiceImpl implements FinanceServiceInterface{
	@Autowired CustomerRepository cr;
	@Autowired EmiStatusRepository esr;
	@Autowired EmployeeRepository er;
	@Autowired LoanRepository lr;
	@Autowired RemarkRepository rr;
	@Autowired JavaMailSender jms;
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return er.save(employee);
	}
	public void sendEmailWithAttach(SendEmail s, MultipartFile f) throws MessagingException {
		
		MimeMessage mm=jms.createMimeMessage();
		
		MimeMessageHelper mmh=new MimeMessageHelper(mm,true);
		mmh.setText(s.getTextBody());
		mmh.setFrom(s.getFromEmail());
		mmh.setTo(s.getToEmail());
		mmh.setSubject(s.getSubject());
		
		mmh.addAttachment(f.getOriginalFilename(), f);
		jms.send(mm);
		
		System.out.println("Mail Sent");
		
	}
}
