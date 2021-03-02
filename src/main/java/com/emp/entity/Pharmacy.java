package com.emp.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {
	
	private Long pharmId;
	
	private String pharmacyName;
	
	private String address;
	
	private String contactNumber;
	
	private LocalDate establishedDate;
	
	private Boolean isClosed;
	
	private LocalDate closedDate;
	
	private String closedReason;

}
