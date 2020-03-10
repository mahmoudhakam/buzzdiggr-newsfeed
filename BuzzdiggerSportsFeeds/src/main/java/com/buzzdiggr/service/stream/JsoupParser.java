package com.buzzdiggr.service.stream;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buzzdiggr.models.Article;
import com.buzzdiggr.service.producer.KafkaPublisher;
/**
 * @author MahmoudHakam
 * This class is responsible for visiting websites, collecting data and parsing it
 * */
@Service
public class JsoupParser
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private KafkaPublisher kafkaPublisher;
	private ConfiguredKeyWords favouredUserTopics;
	private Set<String> visitedURLs = new HashSet<>();
	private final static Pattern EXCLUSIONS = Pattern.compile(".*(\\.(css|js|xml|gif|jpg|png|mp3|mp4|zip|gz|pdf))$");

	@Autowired
	public JsoupParser(KafkaPublisher kafkaPublisher, ConfiguredKeyWords favouredUserTopics)
	{
		super();
		this.kafkaPublisher = kafkaPublisher;
		this.favouredUserTopics = favouredUserTopics;
	}

	private Connection getJsoupConnection(String url)
	{
		visitedURLs.add(url);
		Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
		if(connection.response().contentType() != null && !connection.response().contentType().contains("text/html"))
		{
			return null;
		}
		return connection;
	}

	private Article getDocumentContent(Document document, String url, String source)
	{
		if(document.body() != null)
		{
			String description = document.body().text();
			String title = document.title();
			if(checkIfArticleIsFavoured(description, title))
			{
				Article article = Article.of(url, source,  title);
				return article;
			}
		}
		return null;
	}

	private boolean checkIfArticleIsFavoured(String description, String title)
	{
		for(String topic : favouredUserTopics.getUserFavouredToics())
		{
			if(title.contains(topic) || description.contains(topic))
			{
				return true;
			}
		}
		return false;
	}

	private void processInnerLinks(Document document, String source, String parentURL)
	{
		Elements linksOnPage = document.select("a[href]");
		for(Element link : linksOnPage)
		{
			String absUrl = link.absUrl("href");
			if(!EXCLUSIONS.matcher(absUrl).matches() && absUrl.contains(parentURL) && !visitedURLs.contains(absUrl))
			{
				parse(absUrl, source, parentURL);
			}
		}
	}

	public void parse(String url, String source, String parentURL)
	{
		try
		{
			Connection connection = getJsoupConnection(url);
			logger.info("Tring to parse URL:{} , Parent URL:{}", url, parentURL);
			if(connection != null)
			{
				Document document = connection.get();
				if(document != null)
				{
					Article article = getDocumentContent(document, url, source);
					if(article != null)
					{
						kafkaPublisher.publishArticle(article);
					}
					processInnerLinks(document, source, parentURL);
				}
			}
		}catch(IOException e)
		{
			logger.error("Error during parsing URL", e);
		}
	}

	public static void main(String[] args)
	{
		String url = "https://www.yallakora.com/Match-Center/%D9%85%D8%B1%D9%83%D8%B2-%D8%A7%D9%84%D9%85%D8%A8%D8%A7%D8%B1%D9%8A%D8%A7%D8%AA#nav-menu";
		test(url, "https://www.yallakora.com");
	}

	private static void test(String url, String parent)
	{
		Set<String> visitedURLs = new HashSet<String>();
		visitedURLs.add(url);
		Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
		if(connection.response().contentType() != null && !connection.response().contentType().contains("text/html"))
		{
		}
		Document document = null;
		try
		{
			document = connection.get();
		}catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(document != null)
		{
			String description = document.body().text();
			String title = document.title();
			// System.out.println("title" + title);
			// System.out.println("description" + description);
			// System.out.println("URL"+url);
			Elements linksOnPage = document.select("a[href]");
			for(Element link : linksOnPage)
			{
				String absUrl = link.absUrl("href");
				if(!EXCLUSIONS.matcher(absUrl).matches() && absUrl.contains(parent) && !visitedURLs.contains(absUrl))
				{
					test(absUrl, parent);
				}
			}
		}
	}
}
