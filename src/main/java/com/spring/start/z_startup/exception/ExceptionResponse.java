package com.spring.start.z_startup.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ExceptionResponse {

	private String errorMessage;
	private String requestedURI;
	private List<String> errorMessagesList;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorMessagesList
	 */
	public List<String> getErrorMessagesList() {
		return errorMessagesList;
	}

	/**
	 * @param errorMessagesList the errorMessagesList to set
	 */
	public void setErrorMessagesList(List<String> errorMessagesList) {
		this.errorMessagesList = errorMessagesList;
	}

	/**
	 * @param requestedURI the requestedURI to set
	 */
	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	
}
