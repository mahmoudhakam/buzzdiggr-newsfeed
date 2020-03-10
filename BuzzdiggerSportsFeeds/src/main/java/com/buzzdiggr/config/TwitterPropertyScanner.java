package com.buzzdiggr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "oauth", ignoreUnknownFields = false)
@EnableConfigurationProperties
@Configuration
@Getter
@Setter
public class TwitterPropertyScanner
{
	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;
}
