package com.buzzdiggr.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchRequest
{
	private String query;
	private String source;
	private int page;
	private int size;
	private long totalDocuments;

	public static SearchRequest of(String query,  int page, int size)
	{
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.setPage(page);
		searchRequest.setQuery(query);
		searchRequest.setSize(size);
		return searchRequest;
	}
	public static SearchRequest of(String query, String source, int page, int size)
	{
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.setPage(page);
		searchRequest.setQuery(query);
		searchRequest.setSize(size);
		searchRequest.setSource(source);
		return searchRequest;
	}
}
