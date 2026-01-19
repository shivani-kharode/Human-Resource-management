package com.company.hrm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.hrm.dto.request.DepartmentRequestDTO;
import com.company.hrm.service.IDepartmentService;
import com.company.hrm.util.APIResponse;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;
	
	// POST /api/departments
	// http://localhost:8080/api/department
	
	@PostMapping("/")
	public ResponseEntity<APIResponse> createDepartment(@Valid @RequestBody DepartmentRequestDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new APIResponse<>(
						"SUCESS",
						"DEPARTMENT CREATED SUCcESSFULLY ",
						service.createDepartment(dto)));
	}
	
	// GET /api/departments 
	
	// http://localhost:8080/api/department
	@GetMapping("/")
	 public ResponseEntity<APIResponse> getAllDepartments(){
		return ResponseEntity.ok(new APIResponse<>(
				"SUCCESS",
				"DEPARTEMNT FETCHED SUCCESSFULLY ",
				 service.getAllDepartments()));
	}
}