package com.ffc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String fName;
	private String lName;
	private String role;
	private String address;
	private Long contactNo;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] pan;
	@Lob
	private byte[] aadhar;
	private String userName;
	private String password;
	private String email;
	
}
