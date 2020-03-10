package com.buzzdiggr.service.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.buzzdiggr.models.Article;

@Repository
public interface ArticleRepo extends ElasticsearchRepository<Article, String>
{

}
