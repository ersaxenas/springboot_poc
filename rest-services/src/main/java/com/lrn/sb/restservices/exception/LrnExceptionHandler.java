package com.lrn.sb.restservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/*runs before controllers*/
@ControllerAdvice
@RestController
public class LrnExceptionHandler extends ResponseEntityExceptionHandler {

	/*handle a particular exception class*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> catchAllRepnoseHandler(final Exception exp, final WebRequest request) {
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), exp.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(expResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> catchUserNotFoundRepnoseHandler(final UserNotFoundException exp, final WebRequest request) {
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), exp.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(expResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exp, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), "validation failed", exp.getBindingResult().toString());
		return new ResponseEntity<Object>(expResponse, HttpStatus.BAD_REQUEST);
	}


}
