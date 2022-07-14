package com.ffc.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanId;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customerId;
	private String loanStatus;
	private Double requiredLoanAmount;
	private Double loanAmount;
	private Double loanAmountToBank;
	private Double processingCharge;
	private Double insurance;	
	private Double emi;
	private Float rateOfInterest;
	private Integer tenure;
	private Long generatedBy;
	private Date generatedDate;
	@Lob
	private byte[] sanctionDocument;
	private Date sanctionDocumentDate;
	@Lob
	private byte[] salarySlip;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] bankPassbookCopy;
	@Lob
	private byte[] cancelledCheck;
	@Lob
	private byte[] pdcCheck;	
	private String guarantorName;
	private Long guarantorMobileNo;
	private Long guarantorAadharNo;
	private String guarantorOccupation;
	@Lob
	private byte[] guarantorPhoto;
}
