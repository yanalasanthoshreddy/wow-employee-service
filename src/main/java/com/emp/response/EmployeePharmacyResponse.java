package com.emp.response;

import java.io.Serializable;

import com.emp.entity.Employee;
import com.emp.entity.Pharmacy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePharmacyResponse implements Serializable{
	
	private static final long serialVersionUID = 4186128014739799271L;
	
	private Employee employee;
	
	private Pharmacy pharmacy;
	
	

}
