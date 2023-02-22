package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.controller.productNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(productNotFoundException.class)
	public final ResponseEntity<Object> handleproductNotFoundException(Exception ex, WebRequest request)
			throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// String errors = "";
		StringBuilder errors = new StringBuilder();
		for (FieldError i : ex.getFieldErrors()) {
			errors.append(i.getDefaultMessage());
		}
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
//				"Total errors: " + ex.getErrorCount() + "First error: " + ex.getFieldError().getDefaultMessage(),
//				request.getDescription(false));
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),errors.substring(0),
				request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}
}
