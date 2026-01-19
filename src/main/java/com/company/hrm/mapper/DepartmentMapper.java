package com.company.hrm.mapper;

import com.company.hrm.dto.request.DepartmentRequestDTO;
import com.company.hrm.dto.response.DepartmentResponseDTO;
import com.company.hrm.entity.Department;

public class DepartmentMapper {
	
	public static  Department  toEntity( DepartmentRequestDTO dto) {
		
		Department dept = new Department();
		dept.setDepartmentName(dto.getDepartmentName());
		dept.setDepartmentCode(dto.getDepartmentCode());
		return dept;
	}
	
	public static DepartmentResponseDTO toResponse( Department dept) {
		
		DepartmentResponseDTO dto = new DepartmentResponseDTO();
		
		 dto.setId(dept.getId());
		 dto.setDepartmentName(dept.getDepartmentName());
		 dto.setDepartmentCode(dept.getDepartmentCode());
		 dto.setCreatedAt(dept.getCreatedAt());
		 
		 return dto;
	}
	

}
