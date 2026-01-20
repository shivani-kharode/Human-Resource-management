package com.company.hrm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// GET /api/department
	
	// http://localhost:8080/api/department
	@GetMapping("/")
	 public ResponseEntity<APIResponse> getAllDepartments(){
		return ResponseEntity.ok(new APIResponse<>(
				"SUCCESS",
				"DEPARTEMENTS FETCHED SUCCESSFULLY ",
				 service.getAllDepartments()));
	}
	
	//GET /api/departments/{id} 
	// http://localhost:8080/api/department/
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getDepartmentById(@PathVariable Long id){
		return ResponseEntity.ok(new APIResponse<>(
				"SUCESS",
				"DEPARTMENT FETCHED SUCCESSFULLY",
				service.getDepartmentById(id)));
	}
	
//	● PUT /api/departments/{id} 
	
	// http://localhost:8080/api/department/
	
		@PutMapping("/{id}")
		public ResponseEntity<APIResponse> updateDepartmentById(@PathVariable Long id,@RequestBody DepartmentRequestDTO dto){
			return ResponseEntity.ok(new APIResponse<>(
					"SUCESS",
					"DEPARTMENT UPDATED SUCCESSFULLY",
					service.updateDepartmentById(id,dto)));
		}
	
	// ● DELETE /api/departments/{id} 
		
	// http://localhost:8080/api/department/
		
		@DeleteMapping("/{id}")
		public ResponseEntity<APIResponse> deleteDepartment(@PathVariable Long id){
			service.deleteDepartment(id);
			return ResponseEntity.ok(new APIResponse<>(
					"SUCCESS",
					"DEPARTMENT DELETED SUCCESSFULLY",
					null));
		}
		
}