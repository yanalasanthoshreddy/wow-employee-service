package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.request.EmployeeResponseDTO;
import com.emp.service.EmployeeService;

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
			@ApiResponse(code = 200, message = "Successful retrieval",response = EmployeeResponseDTO.class) 
	})
	@GetMapping(value ="/details/{empid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable(value="empid") String empId) {
		log.info("Input Employee Id :{}",empId);
		return new ResponseEntity<>(employeeService.getEmployeeById(empId),HttpStatus.OK);
	}

}
