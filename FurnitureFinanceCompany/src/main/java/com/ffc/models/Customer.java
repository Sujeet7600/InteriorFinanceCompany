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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private String customerName;
	private String customerEmailId;
	private Long customerContactNumber;
	private String customerLocalAddress;
	private Long customerLocalPincode;
	private String customerPermanantAddress;
	private Long customerPermanantPincode;	
	private String cmRemark;	
	private Integer status;			
	private String panNo;
	private Long aadharNo;
	private String note;	
	@Lob
	private byte[] panCopy;
	@Lob
	private byte[] aadharCopy;
	@Lob
	private byte[] rentAgreement;
	@Lob
	private byte[] photo;

}
