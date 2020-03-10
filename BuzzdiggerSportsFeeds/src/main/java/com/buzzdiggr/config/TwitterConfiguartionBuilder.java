//package com.buzzdiggr.config;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//
//import twitter4j.Twitter;
//import twitter4j.TwitterFactory;
//import twitter4j.conf.ConfigurationBuilder;
//
//@Configurable
//public class TwitterConfiguartionBuilder
//{
//	private TwitterPropertyScanner propertyScanner;
//
//	public TwitterConfiguartionBuilder(TwitterPropertyScanner propertyScanner)
//	{
//		this.propertyScanner = propertyScanner;
//	}
//
//	@Bean("twitterInstance")
//	public Twitter getTwitterInstance()
//	{
//		ConfigurationBuilder cb = new ConfigurationBuilder();
//		cb.setDebugEnabled(true).setOAuthConsumerKey(propertyScanner.getConsumerKey()).setOAuthConsumerSecret(propertyScanner.getConsumerSecret()).setOAuthAccessToken(propertyScanner.getAccessToken())
//				.setOAuthAccessTokenSecret(propertyScanner.getAccessTokenSecret());
//		TwitterFactory tf = new TwitterFactory(cb.build());
//		Twitter twitter = tf.getInstance();
//		return twitter;
//	}
//}
