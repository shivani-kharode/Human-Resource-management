package com.company.hrm.mapper;

import com.company.hrm.dto.request.EmployeeRequestDTO;
import com.company.hrm.dto.response.EmployeeResponseDTO;
import com.company.hrm.entity.Department;
import com.company.hrm.entity.Employee;

public class EmployeeMapper {

	public static Employee toEntity(EmployeeRequestDTO dto) {
		
		Employee emp = new Employee();
		
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		emp.setSalary(dto.getSalary());
		emp.setPhone(dto.getPhone());
	  
		return emp;
	}
	
	public static EmployeeResponseDTO toResponse( Employee emp) {
		
		EmployeeResponseDTO dto =  new EmployeeResponseDTO();
		dto.setId(emp.getId());
		dto.setFirstName(emp.getFirstName());
		dto.setLastName(emp.getLastName());
		dto.setEmpCode(emp.getEmpCode());
		dto.setJoiningDate(emp.getJoiningDate());
		dto.setPhone(emp.getPhone());
		dto.setEmail(emp.getEmail());
		dto.setRole(emp.getRole());
		dto.setSalary(emp.getSalary());
		dto.setStatus(emp.getStatus());
		dto.setDept_id(emp.getDepartment().getId());
		return dto;
	}
	
	public static void  toUpdateEntity(Employee emp,EmployeeRequestDTO dto, Department dept) {
		
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		emp.setSalary(dto.getSalary());
		emp.setPhone(dto.getPhone());
		emp.setDepartment(dept);
	
	}
	
}
