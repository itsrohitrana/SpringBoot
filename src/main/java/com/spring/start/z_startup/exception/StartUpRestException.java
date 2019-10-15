package com.spring.start.z_startup.exception;

import org.springframework.http.HttpStatus;

public class StartUpRestException extends RuntimeException {

	private static final long serialVersionUID = -9079454849611061074L;

	private HttpStatus status;
	public StartUpRestException() {
		super();
	}

	public StartUpRestException(final String message) {
		super(message);
	}

	public StartUpRestException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
