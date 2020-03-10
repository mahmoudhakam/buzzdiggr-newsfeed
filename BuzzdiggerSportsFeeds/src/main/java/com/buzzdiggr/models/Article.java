package com.buzzdiggr.models;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Article
{
	private String id;
	private String url;
	private String source;
	private String articleTitle;

	public static Article of(String url, String source, String title)
	{
		Article article = new Article();
		article.setArticleTitle(title);
		article.setUrl(url);
		article.setSource(source);
		article.setId(System.currentTimeMillis() + "");
		return article;
	}

}
