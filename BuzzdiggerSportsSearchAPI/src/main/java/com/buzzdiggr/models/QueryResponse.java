package com.buzzdiggr.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QueryResponse
{
	private long totalHits;
	private List<Article> articles;

	public static QueryResponse of(long totalDocuments, List<Article> articles)
	{
		QueryResponse response = new QueryResponse();
		response.setArticles(articles);
		response.setTotalHits(totalDocuments);
		return response;
	}
}
