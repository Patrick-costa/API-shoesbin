package com.example.demo.resource.exceptions;

import com.example.demo.service.exceptions.DataIntegrityViolationException;
import com.example.demo.service.exceptions.ObjectnotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandartError> objectnotFoundException(ObjectnotFoundException ex, 
			HttpServletRequest request){
		
		StandartError error = new StandartError(System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), 
				"Object Not Found", 
				ex.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandartError> dataIntegrityViolationException(DataIntegrityViolationException ex, 
			HttpServletRequest request){
		
		StandartError error = new StandartError(System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), 
				"Violação de Dados", 
				ex.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> validationError(MethodArgumentNotValidException ex, 
			HttpServletRequest request){
		
		ValidationError errors = new ValidationError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), 
				"Validation error", 
				"Erro na validação dos campos", 
				request.getRequestURI());
		
		for(FieldError x : ex.getBindingResult().getFieldErrors()) {
			errors.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	
}
