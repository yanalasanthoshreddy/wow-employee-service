package com.emp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeService employeeService;

	@Test
	public void test() {
		System.out.print("Hello test case execuated......................");
		this.employeeService.getEmployeeById(1l);
	}

}
