package com.arcane.pfa.core.personalfinanceapplication.exception;

import org.springframework.http.HttpStatus;

public class GoalException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	public GoalException(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
