package com.arcane.pfa.core.personalfinanceapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GoalExceptionHandler {

	@ExceptionHandler(value = { GoalNotFoundException.class })
	public ResponseEntity<Object> handleGoalNotFoundException(GoalNotFoundException goalNotFoundException) {
		GoalException goalException = new GoalException(goalNotFoundException.getMessage(),
				goalNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(goalException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { InvalidGoalException.class })
	public ResponseEntity<Object> handleInvalidGoalException(InvalidGoalException invalidGoalException) {
		GoalException goalException = new GoalException(invalidGoalException.getMessage(),
				invalidGoalException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(goalException, HttpStatus.NOT_FOUND);
	}
}
