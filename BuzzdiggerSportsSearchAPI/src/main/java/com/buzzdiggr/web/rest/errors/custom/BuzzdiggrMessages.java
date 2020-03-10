package com.buzzdiggr.web.rest.errors.custom;

/**
 * Handle all custom errors returned by search api
 */
public enum BuzzdiggrMessages
{

	RESOURCE_NOT_FOUND("1001", "Resource not found"), INVALID_REQUEST_INPUTS("1002", "Invalid request inputs"), MISSING_REQUEST_PARAMETER("4001", "Missing Request Parameter"),SUCCESS("2001", "Successful Search");

	private String errorNumber;
	private String errorMessage;

	BuzzdiggrMessages(String errorNumber, String errorMessage)
	{
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
	}

	public String getErrorNumber()
	{
		return errorNumber;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

}
