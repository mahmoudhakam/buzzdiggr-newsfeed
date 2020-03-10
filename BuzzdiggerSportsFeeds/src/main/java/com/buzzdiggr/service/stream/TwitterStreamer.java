package com.buzzdiggr.service.stream;

import java.util.List;

import org.springframework.stereotype.Service;

import twitter4j.Status;

/*
 * This class is responsible for streaming data from twitter
 * **/
@Service
public class TwitterStreamer
{

	// private Twitter twitterInstance;
	//
	// public TwitterStreamer(Twitter twitterInstance)
	// {
	// super();
	// this.twitterInstance = twitterInstance;
	// }

	public List<Status> searchtweets(String searchTerms)
	{
		// Query query = new Query(searchTerms);
		// QueryResult result = null;
		// try
		// {
		// result = twitterInstance.search(query);
		// }catch(TwitterException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// List<Status> tweets = result.getTweets();
		// return tweets;
		return null;
	}

}
