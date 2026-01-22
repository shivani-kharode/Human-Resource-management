package com.company.hrm.service;

import java.util.List;

import javax.validation.Valid;

import com.company.hrm.dto.request.EmployeeRequestDTO;
import com.company.hrm.dto.response.EmployeeResponseDTO;

public interface IEmployeeService {

	EmployeeResponseDTO createEmployee(@Valid EmployeeRequestDTO dto);

	List<EmployeeResponseDTO> getEmployees();

	EmployeeResponseDTO getEmployeeById(Long id);

	EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);

	void deleteEmployee(Long id);

}
