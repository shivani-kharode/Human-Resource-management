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

import com.company.hrm.dto.request.EmployeeRequestDTO;
import com.company.hrm.dto.response.EmployeeResponseDTO;
import com.company.hrm.service.IEmployeeService;
import com.company.hrm.util.APIResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;

//	● POST /api/employees 
	// http://localhost:8080/api/employees/
	@PostMapping("/")
	public ResponseEntity<APIResponse> createEmployee(@Valid @RequestBody EmployeeRequestDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new APIResponse<>(
						"SUCCESS",
						"Employee created successfully",
						service.createEmployee(dto)));
	}
//	● GET /api/employees 
	
	// http://localhost:8080/api/employees
	
	@GetMapping("/")
	public ResponseEntity<APIResponse> getEmployees(){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new APIResponse<>(
						"SUCCESS",
						"Employees fetched successfully",
						service.getEmployees()));
				
	}
//	● GET /api/employees/{id} 
	
	// http//localhost:8080/api/employees/{id}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getEmployeeById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new APIResponse<>(
						"SUCCESS",
						"Employee fetched successfully",
						service.getEmployeeById(id)));
	}
//	● PUT /api/employees/{id} 
	// http://localhost:8080/api/employees/{id}
	
	@PutMapping("/{id}")
	public ResponseEntity<APIResponse> updateEmployee(@PathVariable Long id , @RequestBody EmployeeRequestDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new APIResponse<>(
						"SUCCESS",
						"Employee updated successfully",
						service.updateEmployee(id,dto)));
	}
//	● DELETE /api/employees/{id}
	
	// http://localhost:8080/api/employees/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> deleteEmployee(@PathVariable Long id){
		service.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new APIResponse<>(
						"SUCCESS",
						"Employee deleted successfully ",
						null));
	}
	

}
