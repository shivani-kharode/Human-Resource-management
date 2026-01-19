package com.company.hrm.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
	

	  @Id
	  @GeneratedValue(strategy =GenerationType.IDENTITY)
	  @Column(name="department_id")
	  private Long id ;
	  
	  @Column( unique= true ,nullable = false)
	  private  String departmentName;
	  
	  @Column( nullable=false)
	  private String departmentCode ;
	
	  private LocalDateTime createdAt = LocalDateTime.now();
	  
	  @OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	  List<Employee> employees;
	  
	  
	 
}
