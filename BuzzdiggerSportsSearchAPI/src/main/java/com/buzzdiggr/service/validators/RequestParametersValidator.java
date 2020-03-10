package com.buzzdiggr.service.validators;

import org.springframework.stereotype.Service;

import com.buzzdiggr.models.SearchRequest;
/**
 * @author MahmoudHakam
 * 
 * This class demonstrates applying validation on user inputs
 * And also we can sanitize inputs that has a security concerns according to OWASP top ten
 * **/
@Service
public class RequestParametersValidator
{
	public boolean validateMandatoryParameters(SearchRequest searchRequest)
	{
		return queryParameterNotEmpty(searchRequest) && validateMissingSource(searchRequest);
	}

	public boolean queryParameterNotEmpty(SearchRequest searchRequest)
	{
		return !searchRequest.getQuery().isEmpty();
	}

	public boolean validateMissingSource(SearchRequest searchRequest)
	{
		return !searchRequest.getSource().isEmpty();
	}

}
