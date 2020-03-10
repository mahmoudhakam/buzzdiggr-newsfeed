package com.buzzdiggr.models;

import java.util.HashSet;
import java.util.Set;

import com.buzzdiggr.SearchConstants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchResponse
{
	private RequestStatus status;
	private Set<String> filters;
	private QueryResponse result;

	public static Set<String> ofSources()
	{
		Set<String> sources = new HashSet<>();
		sources.add("all");
		sources.add(SearchConstants.Sources.SHROUK);
		sources.add(SearchConstants.Sources.YOUM_SEVEN);
		sources.add(SearchConstants.Sources.YALLA_KORA);
		return sources;
	}

	public static SearchResponse ofSuccess(RequestStatus status, Set<String> filters, QueryResponse result)
	{
		SearchResponse response = new SearchResponse();
		response.setStatus(status);
		response.setFilters(filters);
		response.setResult(result);
		return response;
	}

}
