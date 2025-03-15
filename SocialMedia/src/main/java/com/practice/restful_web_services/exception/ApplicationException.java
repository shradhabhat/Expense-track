package com.practice.restful_web_services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ApplicationException extends RuntimeException{
	public ApplicationException(String msg) {
		super(msg);
	}

}
