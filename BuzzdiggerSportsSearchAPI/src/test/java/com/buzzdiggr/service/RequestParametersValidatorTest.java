package com.buzzdiggr.service;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.buzzdiggr.models.SearchRequest;
import com.buzzdiggr.service.validators.RequestParametersValidator;
/**
 * Isolated unit test is adopted here
 * No integration with spring boot needed
 * */
@SpringBootTest
public class RequestParametersValidatorTest
{
	private RequestParametersValidator serviceUnderTests;
	SearchRequest searchRequest;

	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		serviceUnderTests = new RequestParametersValidator();
		searchRequest = new SearchRequest();
	}

	@Test
	public void validateMissingQuery_shouldReturnTrue_WhenQueryIsNotEmpty()
	{
		searchRequest.setQuery("query");
		assertTrue(serviceUnderTests.queryParameterNotEmpty(searchRequest));
	}

	@Test
	public void validateMissingQuery_shouldReturnFalse_WhenEmptyQuery()
	{
		searchRequest.setQuery(StringUtils.EMPTY);
		assertFalse(serviceUnderTests.queryParameterNotEmpty(searchRequest));
	}
}
