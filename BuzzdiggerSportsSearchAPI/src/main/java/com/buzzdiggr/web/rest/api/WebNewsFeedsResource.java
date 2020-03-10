package com.buzzdiggr.web.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buzzdiggr.models.QueryResponse;
import com.buzzdiggr.models.RequestStatus;
import com.buzzdiggr.models.SearchRequest;
import com.buzzdiggr.models.SearchResponse;
import com.buzzdiggr.service.NewsFeedsDelegate;
import com.buzzdiggr.web.rest.errors.custom.BuzzdiggrMessages;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = { "Buzzdiggr Search Endpoints" })
public class WebNewsFeedsResource
{
	private NewsFeedsDelegate delegate;

	@Autowired
	public WebNewsFeedsResource(NewsFeedsDelegate delegate)
	{
		this.delegate = delegate;
	}

	@ApiOperation(value = "Get all available topics for searched term")
	@GetMapping("/searchAll")
	public ResponseEntity<SearchResponse> searchAll(@RequestParam(name = "q", defaultValue = "") String query, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size)
	{
		long start = System.currentTimeMillis();
		SearchRequest searchRequest = SearchRequest.of(query, page, size);
		QueryResponse response = delegate.searchAll(searchRequest);
		String serviceTime = (System.currentTimeMillis() - start) + " ms";
		RequestStatus status = RequestStatus.of(true, BuzzdiggrMessages.SUCCESS.getErrorNumber(), BuzzdiggrMessages.SUCCESS.getErrorMessage(), serviceTime);
		return new ResponseEntity<>(SearchResponse.ofSuccess(status, SearchResponse.ofSources(), response), HttpStatus.OK);
	}

	@ApiOperation(value = "Get available topics for searched term from only one filtered source")
	@GetMapping("/searchSource")
	public ResponseEntity<SearchResponse> searchWithSource(@RequestParam(name = "q", defaultValue = "") String query, @RequestParam(name = "source", defaultValue = "") String source, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size)
	{
		long start = System.currentTimeMillis();
		SearchRequest searchRequest = SearchRequest.of(query, source, page, size);
		QueryResponse response = delegate.searchWithSource(searchRequest);
		String serviceTime = (System.currentTimeMillis() - start) + " ms";
		RequestStatus status = RequestStatus.of(true, BuzzdiggrMessages.SUCCESS.getErrorNumber(), BuzzdiggrMessages.SUCCESS.getErrorMessage(), serviceTime);
		return new ResponseEntity<>(SearchResponse.ofSuccess(status, SearchResponse.ofSources(), response), HttpStatus.OK);
	}
}
