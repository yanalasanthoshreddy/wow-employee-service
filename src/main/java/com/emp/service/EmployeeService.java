package com.emp.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.emp.entity.Employee;
import com.emp.entity.Pharmacy;
import com.emp.repository.EmployeeRepository;
import com.emp.response.EmployeePharmacyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/** Below service method return employee details
	 *  
	 *  based on employee ID.
	 * 
	 * @param empId
	 * @return Employee
	 */
	public Employee getEmployeeById(Long empId) {
		log.info("EmployeeService::Input Value :{}",empId);
		return this.employeeRepository.findById(empId).orElse(null);
	}
	
	
	
	/**
	 * Below service method persist the employee data.
	 * @param employee
	 * @return Employee
	 * @throws JsonProcessingException 
	 */ 
	@Transactional(isolation =Isolation.DEFAULT,propagation = Propagation.REQUIRES_NEW)
	public Employee saveEmployee(Employee employee) throws JsonProcessingException {
		log.info("Employee Create Request :{}",this.objectMapper.writeValueAsString(employee));
		return this.employeeRepository.save(employee);
	}


	/**
	 * Below service method persist the employee data.
	 * @param employee
	 * @return Employee
	 * @throws JsonProcessingException 
	 */ 
	@Transactional(isolation =Isolation.DEFAULT,propagation = Propagation.REQUIRES_NEW)
	public Employee editEmployee(Employee employee) throws JsonProcessingException {
		log.info("Employee Update Request :{}",this.objectMapper.writeValueAsString(employee));
		return this.employeeRepository.save(employee);
	}


	/**
	 * Below service method persist the employee data.
	 * @param employee
	 * @return Employee
	 * @throws JsonProcessingException 
	 */ 
	@Transactional(isolation =Isolation.DEFAULT,propagation = Propagation.REQUIRES_NEW)
	public String deleteEmployee(Long empId) {
		log.info("Employee Delete Request :{}",empId);
		this.employeeRepository.deleteById(empId);
		return "Successfully deleted the employee details for id :"+empId;
	}



	public EmployeePharmacyResponse getEmployeePharmacyDetailsById(Long empId) {
		EmployeePharmacyResponse emplyeeResponse=new EmployeePharmacyResponse();
		Employee employee=this.employeeRepository.findById(empId).orElse(null);
		if(Objects.nonNull(employee)) {
			ResponseEntity<Pharmacy> pharmacy=this.restTemplate.getForEntity("http://PHARMACY-SERVICE/pharmacy/details/"+empId,Pharmacy.class);
			emplyeeResponse.setEmployee(employee);
			emplyeeResponse.setPharmacy(pharmacy.getBody());
		}
		return emplyeeResponse;
	}

}
