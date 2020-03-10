package com.buzzdiggr.service.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.buzzdiggr.BuzzdiggrConstants;
import com.buzzdiggr.models.Article;
/**
 * @author MahmoudHakam
 * 
 * This class is to publish data to kafka
 *  
 * **/
@Service
public class KafkaPublisher
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${" + BuzzdiggrConstants.Kafka.ARTICLES_TOPIC + "}")
	String webTopicName;

	private KafkaTemplate<String, Article> articlesPublisher;

	@Autowired
	public KafkaPublisher(KafkaTemplate<String, Article> articlesPublisher)
	{
		super();
		this.articlesPublisher = articlesPublisher;
	}

	public void publishArticle(Article data)
	{
		logger.info("Sending message to kafka topic:{} , message:{}", webTopicName, data);
		articlesPublisher.send(webTopicName, data);
	}

}
