package com.buzzdiggr.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.buzzdiggr.models.Article;

@Configuration
public class KafkaProducerConfigurations
{
	@Value("${kafka.boot.server}")
	private String kafkaServer;

	// @Bean
	// public ProducerFactory<String, Tweet> tweetProducerFactory()
	// {
	// Map<String, Object> config = new HashMap<>();
	// config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
	// config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	// config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	// return new DefaultKafkaProducerFactory<>(config);
	// }
	//
	// @Bean
	// public KafkaTemplate<String, Tweet> tweetKafkaTemplate()
	// {
	// return new KafkaTemplate<>(tweetProducerFactory());
	// }

	@Bean
	public ProducerFactory<String, Article> webKafkaFactory()
	{
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//		config.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "3000000");
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, Article> articlesPublisher()
	{
		return new KafkaTemplate<>(webKafkaFactory());
	}
}
