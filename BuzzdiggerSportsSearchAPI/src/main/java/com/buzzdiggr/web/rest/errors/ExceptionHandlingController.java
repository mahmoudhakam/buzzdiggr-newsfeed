package com.buzzdiggr.web.rest.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.buzzdiggr.web.rest.errors.custom.MissingParameterException;
import com.buzzdiggr.web.rest.errors.custom.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler
{
	private final Logger log = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFound(final ResourceNotFoundException e, final WebRequest request)
	{
		log.error("Error: {} / {}", e.getErrorNumber(), e.getMessage());
		ApiError apiError = new ApiError(e.getErrorNumber(), e.getErrorMessage());
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingParameterException.class)
	public ResponseEntity<ApiError> handleResourceNotFound(final MissingParameterException e, final WebRequest request)
	{
		log.error("Error: {} / {}", e.getErrorNumber(), e.getErrorMessage());
		ApiError apiError = new ApiError(e.getErrorNumber(), e.getErrorMessage());
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

}
