package com.buzzdiggr.service;

import java.util.Set;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.buzzdiggr.models.Article;
import com.buzzdiggr.models.QueryResponse;
import com.buzzdiggr.web.rest.errors.custom.ResourceNotFoundException;
@Service
public class ElasticQueriesResponseMapper
{
	private ElasticsearchOperations elasticsearchOperations;
	private ElasticQueriesHandler elasticQueriesHandler;

	public ElasticQueriesResponseMapper(ElasticsearchOperations elasticsearchOperations, ElasticQueriesHandler elasticQueriesHandler)
	{
		super();
		this.elasticsearchOperations = elasticsearchOperations;
		this.elasticQueriesHandler = elasticQueriesHandler;
	}

	public QueryResponse getQueryResponse(String searchTerm, Set<String> fields, int page, int size)
	{
		SearchQuery getAllQuery = elasticQueriesHandler.getSearchQuery(searchTerm, fields, page, size);
		AggregatedPage<Article> queryResult = executeElasticQuery(getAllQuery, Article.class);
		if(queryResult.hasContent())
		{
			return QueryResponse.of(queryResult.getTotalElements(), queryResult.getContent());
		}
		throw new ResourceNotFoundException();
	}

	public QueryResponse getQueryResponse(String searchTerm, Set<String> fields, int page, int size, String source)
	{
		SearchQuery getAllQuery = elasticQueriesHandler.getSearchQuery(searchTerm, fields, page, size, source);
		AggregatedPage<Article> queryResult = executeElasticQuery(getAllQuery, Article.class);
		if(queryResult.hasContent())
		{
			return QueryResponse.of(queryResult.getTotalElements(), queryResult.getContent());
		}
		throw new ResourceNotFoundException();
	}

	protected <T> AggregatedPage<T> executeElasticQuery(SearchQuery query, Class<T> clazz)
	{
		return (AggregatedPage<T>) elasticsearchOperations.queryForPage(query, clazz);
	}

}
