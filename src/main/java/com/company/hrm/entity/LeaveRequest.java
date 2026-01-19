package com.company.hrm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.company.hrm.enums.LeaveStatus;
import com.company.hrm.enums.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long leaverequestId;
	
	@ManyToOne
	@JoinColumn(name ="employee_id")
	private Employee employee;
	
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
   
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = LocalDate.now();
   
    private String reason;
   
   @Enumerated(EnumType.STRING)
   private LeaveStatus status;

}
