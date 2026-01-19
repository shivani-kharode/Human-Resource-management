package com.company.hrm.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDTO {
	  
	  @NotBlank(message ="Department name is required")
	  private  String departmentName;
	  
	  @NotBlank(message ="DepartmentCode is required")
	  private String departmentCode ;

}
