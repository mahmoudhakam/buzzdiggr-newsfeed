package com.buzzdiggr.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Document(indexName = "web", type = "article")
@Builder
public class Article
{

	@Id
	private String id;
	private String url;
	private String source;
	private String articleTitle;
	private Date insertionDate;

	public static Article of(String url, String source, String title)
	{
		Article article = new Article();
		article.setArticleTitle(title);
		article.setUrl(url);
		article.setSource(source);
		article.setId(System.currentTimeMillis() + "");
		return article;
	}

	public static Set<String> buildArticleSearchFields()
	{
		Set<String> fields = new HashSet<>();
		fields.add("articleTitle");
		return fields;
	}

	public Article(String id, String url, String source, String articleTitle, Date insertionDate)
	{
		super();
		this.id = id;
		this.url = url;
		this.source = source;
		this.articleTitle = articleTitle;
		this.insertionDate = insertionDate;
	}

}
