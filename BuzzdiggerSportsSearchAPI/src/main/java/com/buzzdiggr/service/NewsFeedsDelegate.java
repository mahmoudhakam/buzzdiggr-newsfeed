package com.buzzdiggr.service;

import org.springframework.stereotype.Service;

import com.buzzdiggr.models.Article;
import com.buzzdiggr.models.QueryResponse;
import com.buzzdiggr.models.SearchRequest;
import com.buzzdiggr.service.validators.RequestParametersValidator;
import com.buzzdiggr.web.rest.errors.custom.MissingParameterException;

/**
 * @author MahmoudHakam This class is responsible for delegation from Endpoint to services layer
 */
@Service
public class NewsFeedsDelegate
{
	private RequestParametersValidator validators;
	private ElasticQueriesResponseMapper elasticQueriesResponseMapper;

	public NewsFeedsDelegate(RequestParametersValidator validators, ElasticQueriesResponseMapper elasticQueriesResponseMapper)
	{
		super();
		this.validators = validators;
		this.elasticQueriesResponseMapper = elasticQueriesResponseMapper;
	}

	public QueryResponse searchAll(SearchRequest searchRequest)
	{
		if(!validators.queryParameterNotEmpty(searchRequest))
		{
			throw new MissingParameterException();
		}
		return elasticQueriesResponseMapper.getQueryResponse(searchRequest.getQuery(), Article.buildArticleSearchFields(), searchRequest.getPage(), searchRequest.getSize());
	}

	public QueryResponse searchWithSource(SearchRequest searchRequest)
	{
		if(!validators.validateMandatoryParameters(searchRequest))
		{
			throw new MissingParameterException();
		}
		return elasticQueriesResponseMapper.getQueryResponse(searchRequest.getQuery(), Article.buildArticleSearchFields(), searchRequest.getPage(), searchRequest.getSize(), searchRequest.getSource());
	}

}
