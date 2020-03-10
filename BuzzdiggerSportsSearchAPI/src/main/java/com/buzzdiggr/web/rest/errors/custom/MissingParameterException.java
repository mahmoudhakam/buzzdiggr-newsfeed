package com.buzzdiggr.web.rest.errors.custom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissingParameterException extends RuntimeException
{
	private String errorNumber = BuzzdiggrMessages.MISSING_REQUEST_PARAMETER.getErrorNumber();
	private String errorMessage = BuzzdiggrMessages.MISSING_REQUEST_PARAMETER.getErrorMessage();
}
