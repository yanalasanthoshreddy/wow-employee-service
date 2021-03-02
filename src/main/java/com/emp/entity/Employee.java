package com.emp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	private String empName;
	
	private Double salary;
	
	private Long pharmacyId;
	
	private String address;
	
	private LocalDate empJoinedDate;
	
	private Boolean isActive;
	
	private LocalDate empLeftDate;
	
	private String assignedLocation;
	
	private String mobileNo;
	
}
