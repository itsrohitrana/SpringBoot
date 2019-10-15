package com.spring.start.z_startup.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * this class is used for the exception handling all exceptions catched here and
 * throw gracefull message
 * 
 * @author harsh.kumar1
 *
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {
		logger.error("exception occured for request {} and exception is {}", request.getRequestURI(), exception);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StartUpRestException.class)
	public ResponseEntity<ExceptionResponse> handleKalbosRestException(final StartUpRestException exception,
			final HttpServletRequest request) {
		logger.error("exception occured for request {} and exception is {}", request.getRequestURI(), exception);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(
			final MethodArgumentNotValidException exception, final HttpServletRequest request) {
		logger.error("exception occured for request {} and exception is {}", request.getRequestURI(), exception);
		List<String> errors = new ArrayList<String>();
		ExceptionResponse error = new ExceptionResponse();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
		}
		error.setErrorMessagesList(errors);
		error.setRequestedURI(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleException(final Exception exception,
			final HttpServletRequest request) {
		logger.error("exception occured for request {} and exception is {}", request.getRequestURI(), exception);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleHttpMediaTypeNotSupportedException(
			final HttpMediaTypeNotSupportedException exception, final HttpServletRequest request) {
		logger.error("exception occured for request {} and exception is {}", request.getRequestURI(), exception);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedURI(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNoHandlerFoundException(NoHandlerFoundException exception,
			final HttpServletRequest request) {
		logger.error("exception occured for request {} and exception is {}", request.getRequestURI(), exception);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("URL does not exist");
		error.setRequestedURI(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(StartUpMediaRestException.class)
//	public ResponseEntity<ExceptionResponse> handleKalbosRestException(final StartUpMediaRestException exception,
//			final HttpServletRequest request) {
//		List<String> errors = new ArrayList<String>();
//		ExceptionResponse error = new ExceptionResponse();
//		List<StartUpMediaRestException> listOfExceptions = exception.getListOfErrors();
//		if (listOfExceptions != null && listOfExceptions.size() > 0) {
//			for (StartUpMediaRestException fieldError : listOfExceptions) {
//				StringBuffer errrorMessage = new StringBuffer();
//				if (fieldError.getMediaType() != null) {
//					errrorMessage.append(fieldError.getMediaType());
//					if (fieldError.getPageId() != null || fieldError.getMessage() != null) {
//						errrorMessage.append(" : ");
//					}
//				}
//				if (fieldError.getPageId() != null) {
//					errrorMessage.append(fieldError.getPageId());
//					if (fieldError.getMessage() != null) {
//						errrorMessage.append(" : ");
//					}
//				}
//				if (fieldError.getMessage() != null) {
//					errrorMessage.append(fieldError.getMessage());
//				}
//				errors.add(errrorMessage.toString());
//			}
//			error.setErrorMessagesList(errors);
//		} else {
//			error.setErrorMessage(exception.getMessage());
//		}
//		error.setRequestedURI(request.getRequestURI());
//		return new ResponseEntity<>(error,
//				exception.getStatus() != null ? exception.getStatus() : HttpStatus.BAD_REQUEST);
//	}

}
