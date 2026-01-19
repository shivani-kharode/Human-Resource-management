package com.company.hrm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.company.hrm.enums.EmployeeRole;
import com.company.hrm.enums.EmployeeStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long id;
	
	@Column(unique= true , nullable = false)
	private String empCode ;
	
	private String firstName ;
	private String lastName ;
	
	@Column( unique  = true , nullable = false)
	private String  email ;
	
	private String phone ;
	private Double salary ;
	
	private LocalDate joiningDate = LocalDate.now() ;
	
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status ;
	
	@Enumerated(EnumType.STRING)
	private EmployeeRole role;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department ;
	
	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	List<Attendance> attendance;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	List<LeaveRequest> leaverequest;
	

}
