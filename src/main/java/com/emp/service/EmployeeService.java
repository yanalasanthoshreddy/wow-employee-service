package com.emp.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emp.request.EmployeeResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {
	
	/** Below service method return employee details
	 *  
	 *  based on employee ID.
	 * 
	 * @param empId
	 * @return EmployeeResponseDTO
	 */
	public EmployeeResponseDTO getEmployeeById(String empId) {
		log.info("EmployeeService::Input Value :{}",empId);
		return EmployeeResponseDTO
				.builder().aadharNumber("7453 5099 8193").accountCreatedTime(ZonedDateTime.now(ZoneId.systemDefault()))
				.age(32).bankDetails("A/C : 059801532774, SANTHOSH REDDY YANALA, MINDSPACE BRANCH, ICIC0000598")
				.companyName("Deloitte").currentAddress("Flat No : 204, Spring Valley, KRCR Colony, Road No 1, Bachupally, Hyderabad, 500090")
				.dob("12-May-1987").empId("EMP0000100").fullName("SANTHOSH REDDY YANALA").gender("MALE")
				.isCurrentAndPermanentSame(Boolean.FALSE).pandCardNo("ACHPY2046F").password("Basv@2808")
				.permanentAddress("H.No: 1-43, Pallempu, Pahilwanpur, Valigonda, Yadadri-Bhuvanagiri, 508285")
				.salaryPerMonth(150000.0d).uniqueId(UUID.randomUUID()).userId("yanalasanthoshreddy").userType("Employee").build();
	}

}
