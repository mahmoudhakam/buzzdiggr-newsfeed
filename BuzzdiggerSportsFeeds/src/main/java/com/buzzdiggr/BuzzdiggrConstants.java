package com.buzzdiggr;

public class BuzzdiggrConstants
{
	public static class Kafka
	{
		private Kafka()
		{
		}

		public static final String YALLAKORA_TOPIC_NAME = "yallakoraTopic";
		public static final String KAFKA_GROUP_ID = "group_id";
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

	public static class Domains
	{
		private Domains()
		{
		}

		public static final String YALLA_KORA = "http://www.yallakora.com/";
		public static final String YOUM_SEVEN = "https://www.youm7.com/";
		public static final String SHROUK = "https://www.shorouknews.com/";
	}
}
