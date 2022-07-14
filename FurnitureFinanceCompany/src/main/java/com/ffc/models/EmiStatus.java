package com.ffc.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmiStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emiId;
	private Long loanId;
	private Integer installmentNo;
	private Double installmentAmount;
	private Date  installmentDate;
	private Integer installmentStatus;
}
