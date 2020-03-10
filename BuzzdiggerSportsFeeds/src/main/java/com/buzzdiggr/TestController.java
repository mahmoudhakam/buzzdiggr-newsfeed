package com.buzzdiggr;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buzzdiggr.service.stream.TwitterStreamer;

import twitter4j.Status;

/**
 * @author MahmoudHakam
 * 
 * Under development
 * Waiting for twitter to approve the created application
 * 
 ***/

@RestController
@RequestMapping("/api")
public class TestController
{
	private TwitterStreamer twitter;

	@GetMapping("/tweets")
	public List<Status> getTweets(@RequestParam(name = "q", defaultValue = "") String searchTerms)
	{
		return twitter.searchtweets(searchTerms);
	}
}
