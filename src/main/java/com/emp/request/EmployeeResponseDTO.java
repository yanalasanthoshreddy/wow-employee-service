package com.emp.request;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeResponseDTO implements Serializable{

	private static final long serialVersionUID = -1313398262714649517L;

	private String empId;
	
	private String fullName;
	
	private String aadharNumber;
	
	private String pandCardNo;
	
	private String dob;
	
	private String currentAddress;
	
	private String permanentAddress;
	
	private Boolean isCurrentAndPermanentSame;
	
	private Integer age;
	
	private String companyName;
	
	private Double salaryPerMonth;
	
	private String bankDetails;
	
	private String gender;
	
	private UUID uniqueId;
	
	private String userId;
	
	private String password;
	
	private String userType;
	
	private ZonedDateTime accountCreatedTime;
}
