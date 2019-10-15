package com.spring.start.z_startup.exception;

import java.util.List;
import java.util.concurrent.CompletionException;

import org.springframework.http.HttpStatus;

public class StartUpMediaRestException extends CompletionException {

	private static final long serialVersionUID = -9079454849611061074L;

	private HttpStatus status;
	private Long pageId;
	private String mediaType;
	private List<StartUpMediaRestException> listOfErrors;

	public StartUpMediaRestException(String message, HttpStatus status, Long pageId, String mediaType) {
		this(message, status);
		this.pageId = pageId;
		this.mediaType = mediaType;
	}

	public StartUpMediaRestException(List<StartUpMediaRestException> listOfErrors) {
		super();
		this.listOfErrors = listOfErrors;
	}

	public StartUpMediaRestException() {
		super();
	}

	public StartUpMediaRestException(final String message) {
		super(message);
	}

	public StartUpMediaRestException(String message, HttpStatus status) {
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

	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public List<StartUpMediaRestException> getListOfErrors() {
		return listOfErrors;
	}

	public void setListOfErrors(List<StartUpMediaRestException> listOfErrors) {
		this.listOfErrors = listOfErrors;
	}

}
