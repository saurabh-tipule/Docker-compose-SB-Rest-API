package com.cjc.app.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ArithmeticException.class)
	public ResponseEntity<ApiError> handleArithMeticException(ArithmeticException e, HttpServletRequest request) {
		ApiError apiError = new ApiError();
		apiError.setLocaldateTime(LocalDateTime.now());
		apiError.setStatus(HttpStatus.OK.value());
		apiError.setPath(request.getRequestURI());
		apiError.setMessage("Division by Zero");
		return new ResponseEntity<ApiError>(apiError, HttpStatus.OK);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ApiError> handleNullPointerException(NullPointerException e, HttpServletRequest request) {
		ApiError apiError = new ApiError();
		apiError.setLocaldateTime(LocalDateTime.now());
		apiError.setStatus(HttpStatus.OK.value());
		apiError.setPath(request.getRequestURI());
		apiError.setMessage("Operation Performed on null Value");
		return new ResponseEntity<ApiError>(apiError, HttpStatus.OK);
	}
}
