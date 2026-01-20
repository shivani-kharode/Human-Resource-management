package com.company.hrm.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.hrm.exception.DuplicateRecordException;
import com.company.hrm.exception.ResourceNotFoundException;
import com.company.hrm.util.APIResponse;

@RestControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<APIResponse> handleDuplicateException(DuplicateRecordException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT)
				              .body(new APIResponse<>(
				            		 "FAIL",
				            		 ex.getMessage(),
				            		 null
				            ));
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> handleResourceException(ResourceNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				             .body(new APIResponse<>(
				            		 "FAIL",
				            		 ex.getMessage(),
				            		 null));
	}
}
