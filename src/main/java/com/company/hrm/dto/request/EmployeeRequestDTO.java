package com.company.hrm.dto.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

	@NotBlank
	private String firstName ;
	
	@NotBlank
	private String lastName ;
	
	@Email
	@NotBlank
	private String  email ;
	
	@NotBlank
	private String phone ;
	
	@Positive(message="Salary must be greater than zero")
	@NotNull
	private Double salary ;
	
	@NotNull
	private Long deptId;
	
}
