package com.company.hrm.service;

import java.util.List;

import javax.validation.Valid;

import com.company.hrm.dto.request.DepartmentRequestDTO;
import com.company.hrm.dto.response.DepartmentResponseDTO;

public interface IDepartmentService {

	DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO dto);

	List<DepartmentResponseDTO> getAllDepartments();

	DepartmentResponseDTO getDepartmentById(Long deptId);

	DepartmentResponseDTO updateDepartmentById(Long id, DepartmentRequestDTO dto);

	void deleteDepartment(Long id);

}
