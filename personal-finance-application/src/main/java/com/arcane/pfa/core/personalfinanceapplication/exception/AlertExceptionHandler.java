package com.arcane.pfa.core.personalfinanceapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AlertExceptionHandler {

	@ExceptionHandler(value = { AlertNotFoundException.class })
	public ResponseEntity<Object> handleAlertNotFoundException(AlertNotFoundException alertNotFoundException) {
		AlertException alertException = new AlertException(alertNotFoundException.getMessage(),
				alertNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(alertException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { InvalidAlertException.class })
	public ResponseEntity<Object> handleAlertNotFoundException(InvalidAlertException invalidAlertException) {
		AlertException alertException = new AlertException(invalidAlertException.getMessage(),
				invalidAlertException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(alertException, HttpStatus.NOT_FOUND);
	}
}
