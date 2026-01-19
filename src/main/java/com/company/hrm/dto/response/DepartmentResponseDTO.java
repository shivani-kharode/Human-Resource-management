package com.company.hrm.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentResponseDTO {
	
	  private Long id ;
	  
	  private  String departmentName;
	 
	  private String departmentCode ;
	
	  private LocalDateTime createdAt ;

}
