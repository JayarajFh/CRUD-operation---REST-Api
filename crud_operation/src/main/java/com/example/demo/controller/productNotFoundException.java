package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class productNotFoundException extends RuntimeException {
	public productNotFoundException(String message) {
		super(message);
	}
}
