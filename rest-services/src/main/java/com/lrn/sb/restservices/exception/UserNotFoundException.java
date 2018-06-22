package com.lrn.sb.restservices.exception;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*attach response status with exception.*/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends ContextedRuntimeException {
	private static final long serialVersionUID = 1L;
	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(final String msg, final Exception exp) {
		super(msg, exp);
	}
	public UserNotFoundException(final String msg) {
		super(msg);
	}
	public UserNotFoundException(final Exception exp) {
		super(exp);
	}
}
