package com.arcane.pfa.core.personalfinanceapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BudgetExceptionHandler {
	@ExceptionHandler(value = {BudgetNotFoundException.class})
	public ResponseEntity<Object> handleBudgetNotFoundException(BudgetNotFoundException budgetNotFoundException){
		BudgetException budgetException = new BudgetException(
										budgetNotFoundException.getMessage(),
										budgetNotFoundException.getCause(), 
										HttpStatus.NOT_FOUND);
		return new  ResponseEntity<>(budgetException,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {InvalidBudgetException.class})
	public ResponseEntity<Object> handleInvalidBudgetException(InvalidBudgetException invalidBudgetException){
		BudgetException budgetException = new BudgetException(
				invalidBudgetException.getMessage(),
				invalidBudgetException.getCause(), 
				HttpStatus.NOT_FOUND);
return new  ResponseEntity<>(budgetException,HttpStatus.NOT_FOUND);
	}
}
