package com.company.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.hrm.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long>{

	boolean existsByDepartmentName(String departmentName);
}
