package com.buzzdiggr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buzzdiggr.models.Article;
import com.buzzdiggr.service.repository.ArticleRepo;

@Service
public class IndexDocument
{
	private ArticleRepo articleRepository;

	@Autowired
	public IndexDocument(ArticleRepo articleRepository)
	{
		super();
		this.articleRepository = articleRepository;
	}

	public void addDocumentToArticleIndex(Article entity)
	{
		articleRepository.save(entity);
	}

}
