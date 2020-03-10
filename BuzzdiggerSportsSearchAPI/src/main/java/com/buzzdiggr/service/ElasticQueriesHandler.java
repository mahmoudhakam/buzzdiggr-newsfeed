package com.buzzdiggr.service;

import java.util.Set;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

/**
 * @author MahmoudHakam
 * 
 *         This class is reponsible for building elastic index queries
 */

@Service
public class ElasticQueriesHandler
{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public BoolQueryBuilder searchQueryBuilder(String searchTerm, Set<String> fields, int page, int size)
	{
		QueryStringQueryBuilder termQueryBuilder = QueryBuilders.queryStringQuery("*" + searchTerm + "*").lenient(true);
		fields.forEach(f -> {
			termQueryBuilder.field(f);
		});
		BoolQueryBuilder builder = QueryBuilders.boolQuery();
		builder.must(termQueryBuilder);
		return builder;
	}

	public BoolQueryBuilder searchQueryBuilder(String searchTerm, Set<String> fields, int page, int size, String source)
	{
		BoolQueryBuilder builder = searchQueryBuilder(searchTerm, fields, page, size);
		builder.must(new QueryStringQueryBuilder(source).field("source"));
		return builder;
	}

	public SearchQuery getSearchQuery(String searchTerm, Set<String> fields, int page, int size)
	{
		BoolQueryBuilder builder = searchQueryBuilder(searchTerm, fields, page, size);
		return buildQuery(page, size, builder);
	}

	private SearchQuery buildQuery(int page, int size, BoolQueryBuilder builder)
	{
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
		nativeSearchQueryBuilder.withQuery(builder);
		nativeSearchQueryBuilder.withPageable(PageRequest.of(page, size));
		return nativeSearchQueryBuilder.build();
	}

	public SearchQuery getSearchQuery(String searchTerm, Set<String> fields, int page, int size, String source)
	{
		BoolQueryBuilder builder = searchQueryBuilder(searchTerm, fields, page, size, source);
		return buildQuery(page, size, builder);
	}
}
