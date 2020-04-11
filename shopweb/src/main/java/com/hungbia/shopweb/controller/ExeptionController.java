package com.hungbia.shopweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExeptionController {

	@ExceptionHandler(value = { NoHandlerFoundException.class }) // loi 404
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String exceptionHandler(Exception exception, WebRequest request) {
		return "erro/404";

	}

}
