package com.arcane.pfa.core.personalfinanceapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpenseExceptionHandler {
	
	@ExceptionHandler(value = {ExpenseNotFoundException.class})
	public ResponseEntity<Object> handleExpenseNotFoundException(ExpenseNotFoundException expenseNotFoundException ) {
		
		ExpenseException expenseException = new ExpenseException(
				expenseNotFoundException.getMessage(), 
				expenseNotFoundException.getCause(), 
				HttpStatus.NOT_FOUND);
		
		return new  ResponseEntity<>(expenseException,HttpStatus.NOT_FOUND);
	}
	
	

}
