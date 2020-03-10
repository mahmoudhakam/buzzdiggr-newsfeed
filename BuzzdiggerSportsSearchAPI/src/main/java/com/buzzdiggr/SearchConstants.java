package com.buzzdiggr;

public class SearchConstants
{
	public static class Kafka
	{
		private Kafka()
		{
		}

		public static final String YALLAKORA_TOPIC_NAME = "yallakoraTopic";
		public static final String ARTICLE_GROUP_ID = "kafka.consumer.group.string.id";
		public static final String ARTICLE_FACTORY = "articleKafkaListenerFactory";
		public static final String KAFKA_LISTENER_CONTAINER_FACTORY = "kafkaListenerContainerFactory";
		public static final String ARTICLES_TOPIC = "kafka.topic.articles";
		
	}

	public static class Sources
	{
		private Sources()
		{
		}

		public static final String YALLA_KORA = "yallakoraweb";
		public static final String YOUM_SEVEN = "youmsevenweb";
		public static final String SHROUK = "shroukweb";
	}
}
