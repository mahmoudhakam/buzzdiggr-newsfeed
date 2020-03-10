package com.buzzdiggr;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.buzzdiggr.service.repository")
public class SearchIndexedDataBuzzdiggr
{
	private static final Logger log = LoggerFactory.getLogger(SearchIndexedDataBuzzdiggr.class);

	@Autowired
	private Environment env;

	public static void main(String[] args)
	{
		SpringApplication.run(SearchIndexedDataBuzzdiggr.class, args);
	}

	@PostConstruct
	void inti()
	{
		logApplicationStartup();
	}

	private void logApplicationStartup()
	{
		String protocol = "http";
		if(env.getProperty("server.ssl.key-store") != null)
		{
			protocol = "https";
		}
		String serverPort = env.getProperty("server.port");
		String contextPath = env.getProperty("server.servlet.context-path");
		if(StringUtils.isBlank(contextPath))
		{
			contextPath = "/";
		}
		String hostAddress = "localhost";
		try
		{
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		}catch(UnknownHostException e)
		{
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info(
				"\n----------------------------------------------------------\n\t" + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}{}\n\t" + "External: \t{}://{}:{}{}\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), protocol, serverPort, contextPath, protocol, hostAddress, serverPort, contextPath, env.getActiveProfiles());
	}
}
