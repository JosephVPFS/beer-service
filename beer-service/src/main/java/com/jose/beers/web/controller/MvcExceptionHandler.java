package com.jose.beers.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
		List<String> errors = new ArrayList<String>();
		e.getConstraintViolations().forEach(violation -> errors.add(violation.toString()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
