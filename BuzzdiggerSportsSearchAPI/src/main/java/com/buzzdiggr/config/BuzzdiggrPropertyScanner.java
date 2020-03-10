package com.buzzdiggr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "buzzdiggr", ignoreUnknownFields = false)
@EnableConfigurationProperties
@Configuration
@Getter
@Setter
public class BuzzdiggrPropertyScanner
{
	private String logpath;
	private CorsConfiguration cors = new CorsConfiguration();
}
