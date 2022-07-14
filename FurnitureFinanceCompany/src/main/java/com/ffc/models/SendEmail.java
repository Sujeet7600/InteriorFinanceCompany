package com.ffc.models;

import lombok.Data;

@Data
public class SendEmail {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textBody;
}
