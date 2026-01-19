package com.company.hrm.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.company.hrm.enums.AttendanceStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = 
{
		@UniqueConstraint( columnNames = { "employee_id", "date"})
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="attendance_id")
	private Long AttendanceId;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	private LocalDate date = LocalDate.now();
	private LocalTime  checkIn= LocalTime.now();
	private LocalTime checkOut = LocalTime.now();
	
	@Enumerated(EnumType.STRING)
	private AttendanceStatus status;
	
	
}
