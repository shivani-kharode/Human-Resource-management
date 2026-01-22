package com.company.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.hrm.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByEmail(String email);

}
