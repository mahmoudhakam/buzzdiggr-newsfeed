package com.buzzdiggr.web.rest.errors;

import java.util.HashMap;
import java.util.Map;

public class ApiError
{

	private final String errorNumber;
	private final String errorMessage;
	private final Map<String, String> detailedErrors = new HashMap<>();

	public ApiError(String errorNumber, String message)
	{
		this.errorNumber = errorNumber;
		this.errorMessage = message;
	}

	public String getErrorNumber()
	{
		return errorNumber;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public Map<String, String> getDetailedErrors()
	{
		return detailedErrors;
	}
}
