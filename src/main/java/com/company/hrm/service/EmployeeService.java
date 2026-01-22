package com.company.hrm.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hrm.dto.request.EmployeeRequestDTO;
import com.company.hrm.dto.response.EmployeeResponseDTO;
import com.company.hrm.entity.Department;
import com.company.hrm.entity.Employee;
import com.company.hrm.enums.EmployeeRole;
import com.company.hrm.enums.EmployeeStatus;
import com.company.hrm.exception.DuplicateRecordException;
import com.company.hrm.exception.ResourceNotFoundException;
import com.company.hrm.mapper.EmployeeMapper;
import com.company.hrm.repository.IDepartmentRepository;
import com.company.hrm.repository.IEmployeeRepository;
import com.company.hrm.util.EmployeeCodeUtil;
@Service
@Transactional
public class EmployeeService implements IEmployeeService{
       
	@Autowired
	private IEmployeeRepository repository;
	
	@Autowired
	private IDepartmentRepository deptrepo;
	@Override
	public EmployeeResponseDTO createEmployee( EmployeeRequestDTO dto) {
	       
		if( repository.existsByEmail(dto.getEmail())) {
			throw new  DuplicateRecordException("Email already exists");
		}
		
		Department dept	= deptrepo.findById(dto.getDeptId()).orElseThrow(() -> new ResourceNotFoundException("Department is not found "));
		 Employee emp =  EmployeeMapper.toEntity(dto);
		 
		 emp.setDepartment(dept);
		 emp.setRole(EmployeeRole.EMPLOYEE);
		 emp.setStatus(EmployeeStatus.ACTIVE);
		 
		 long count = repository.count();
		 emp.setEmpCode(EmployeeCodeUtil.generateEmpCode(count));
		 
		Employee semp =  repository.save(emp);
		 
		return EmployeeMapper.toResponse(semp);
	}

	@Override
	public List<EmployeeResponseDTO> getEmployees() {
		       
		List<Employee> emps = repository.findAll();
		
		List<EmployeeResponseDTO> dtos = new ArrayList<>();
		
		for( Employee emp : emps) {
			
			dtos.add(EmployeeMapper.toResponse(emp));
		}
		
		
		          
		return dtos;
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {
		
	Employee emp = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not found "));
	  EmployeeResponseDTO dto = EmployeeMapper.toResponse(emp);
		return dto;
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
	 
		   Employee emp = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
		   
		   if( repository.existsByEmail(dto.getEmail())) {
				throw new  DuplicateRecordException("Email already exists");
			}
			
		   Department dept = deptrepo.findById(dto.getDeptId()).orElseThrow(() -> new ResourceNotFoundException("Department is not found !!"));
		   
		   EmployeeMapper.toUpdateEntity(emp,dto,dept);
		   repository.save(emp);
		   
		return EmployeeMapper.toResponse(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		 Employee emp = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Employee is not found"));
		 
		 repository.delete(emp);
		 
		
	}

}
