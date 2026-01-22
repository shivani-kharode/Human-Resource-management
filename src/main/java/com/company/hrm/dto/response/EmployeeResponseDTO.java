package com.company.hrm.dto.response;

import java.time.LocalDate;
import com.company.hrm.enums.EmployeeRole;
import com.company.hrm.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {

    private Long id;
	private String empCode ;
	private String firstName ;
	private String lastName ;
	private String  email ;
	private String phone ;
	private Double salary ;
	private LocalDate joiningDate;
	private EmployeeStatus status ;
	private EmployeeRole role;
	private Long dept_id;
}
