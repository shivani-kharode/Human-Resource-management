package com.company.hrm.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hrm.dto.request.DepartmentRequestDTO;
import com.company.hrm.dto.response.DepartmentResponseDTO;
import com.company.hrm.entity.Department;
import com.company.hrm.exception.DuplicateRecordException;
import com.company.hrm.mapper.DepartmentMapper;
import com.company.hrm.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;
	
	@Override
	public DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO dto) {
	       
		if( repository.existsByDepartmentName(dto.getDepartmentName())) {
			throw new DuplicateRecordException("Department already exists");
			
		}
		      
		Department dept = DepartmentMapper.toEntity(dto);
		Department sdept = repository.save(dept);
		 
		return DepartmentMapper.toResponse(sdept);
	}

	@Override
	public List<DepartmentResponseDTO> getAllDepartments() {
		
	List<Department> depts = repository.findAll();
	
	List<DepartmentResponseDTO> dtos = new ArrayList<>();
	
	for( Department dept : depts) {
		
		dtos.add(DepartmentMapper.toResponse(dept));
	}
	
		return dtos;
	}

}
