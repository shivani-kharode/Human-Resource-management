package com.company.hrm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hrm.dto.request.DepartmentRequestDTO;
import com.company.hrm.dto.response.DepartmentResponseDTO;
import com.company.hrm.entity.Department;
import com.company.hrm.exception.DuplicateRecordException;
import com.company.hrm.exception.ResourceNotFoundException;
import com.company.hrm.mapper.DepartmentMapper;
import com.company.hrm.repository.IDepartmentRepository;

@Service
@Transactional
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

	@Override
	public DepartmentResponseDTO getDepartmentById(Long deptId) {
		          
	Department dept	= repository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Department is not found with id :"+deptId));
	
	 DepartmentResponseDTO dto =  DepartmentMapper.toResponse(dept);
		return dto;
	}

	@Override
	public DepartmentResponseDTO updateDepartmentById(Long id, DepartmentRequestDTO dto) {
		            
		Department dept =repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department is not found with id "+id));
		
	    DepartmentMapper.updateEntity(dept,dto);
	    
	    DepartmentResponseDTO udto =DepartmentMapper.toResponse(repository.save(dept));
		
		return udto;
	}

	@Override
	
	public void deleteDepartment(Long id) {
		Department dept =repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department is not found with id "+id));
		repository.delete(dept);
	}

}
