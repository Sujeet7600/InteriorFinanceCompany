package com.ffc.models;

import java.util.Date;

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
public class Remark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String discription;
	private long eid;
	private long toEid;
	private boolean status;
	private Date date;

}
