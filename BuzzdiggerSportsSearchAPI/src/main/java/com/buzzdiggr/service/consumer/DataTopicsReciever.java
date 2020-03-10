package com.buzzdiggr.service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.buzzdiggr.SearchConstants;
import com.buzzdiggr.models.Article;
import com.buzzdiggr.service.IndexDocument;

@Service
public class DataTopicsReciever
{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private IndexDocument indexDocument;

	@Autowired
	public DataTopicsReciever(IndexDocument indexDocument)
	{
		super();
		this.indexDocument = indexDocument;
	}

	@KafkaListener(topics = "${" + SearchConstants.Kafka.ARTICLES_TOPIC + "}", groupId = "${" + SearchConstants.Kafka.ARTICLE_GROUP_ID + "}", containerFactory = SearchConstants.Kafka.ARTICLE_FACTORY)
	public void consume(Article message)
	{
		LOGGER.info("Recieved data='{}' from kafka", message);
		indexDocument.addDocumentToArticleIndex(message);
	}
}
