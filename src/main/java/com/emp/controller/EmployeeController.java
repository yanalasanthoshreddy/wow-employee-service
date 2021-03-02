package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.request.EmployeeResponseDTO;
import com.emp.response.EmployeePharmacyResponse;
import com.emp.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 
	 * @param empId
	 * @return EmployeeResponseDTO
	 */
	@ApiOperation(value="Get Employee Details By Employee Id",tags = "Employee Query")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful Retrieved the Employee Details",response = EmployeeResponseDTO.class) 
	})
	@GetMapping(value ="/details/{empid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="empid") Long empId) {
		log.info("Input Employee Id :{}",empId);
		return new ResponseEntity<>(employeeService.getEmployeeById(empId),HttpStatus.OK);
	}
	
	
	/**Save Employee Details
	 * 
	 * @param Employee
	 * @return Employee
	 * @throws JsonProcessingException 
	 */
	@ApiOperation(value="Save Employee Details",tags = "Employee Command")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful Saved the employee details",response = Employee.class) 
	})
	@PostMapping(value ="/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws JsonProcessingException {
		return new ResponseEntity<>(this.employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	/**Save Employee Details
	 * 
	 * @param Employee
	 * @return Employee
	 * @throws JsonProcessingException 
	 */
	@ApiOperation(value="Update Employee Details",tags = "Employee Command")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful Updated the employee details",response = Employee.class) 
	})
	@PutMapping(value ="/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee) throws JsonProcessingException {
		return new ResponseEntity<>(this.employeeService.editEmployee(employee),HttpStatus.OK);
	}
	
	
	/**Save Employee Details
	 * 
	 * @param Employee
	 * @return Employee
	 * @throws JsonProcessingException 
	 */
	@ApiOperation(value="Delete Employee Details",tags = "Employee Command")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful Deleted the employee details",response = String.class) 
	})
	@DeleteMapping(value ="/details/{empid}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("empid") Long empId)  {
		return new ResponseEntity<>(this.employeeService.deleteEmployee(empId),HttpStatus.OK);
	}

	/**
	 * Below method retrieve the Employee Pharmacy Detailsby ID
	 * 
	 * @param empId
	 * @return EmployeeResponseDTO
	 */
	@ApiOperation(value="Get Employee Pharmacy Details By Employee Id",tags = "Employee Query")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful Retrieved the Employee Pharmacy Details",response = EmployeeResponseDTO.class) 
	})
	@GetMapping(value ="/pharmacy/details/{empid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeePharmacyResponse> getEmployeePharmacyDetailsById(@PathVariable(value="empid") Long empId) {
		log.info("Input Employee Id :{}",empId);
		return new ResponseEntity<>(employeeService.getEmployeePharmacyDetailsById(empId),HttpStatus.OK);
	}
}
