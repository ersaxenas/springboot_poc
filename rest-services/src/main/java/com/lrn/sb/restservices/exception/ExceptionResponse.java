package com.lrn.sb.restservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
	public ExceptionResponse() {
	}


	public ExceptionResponse(final Date timestamp, final String message, final String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}


	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(final Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(final String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(final String details) {
		this.details = details;
	}


}
