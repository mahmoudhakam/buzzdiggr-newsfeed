package com.buzzdiggr.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Document(indexName = "social", type = "post")
public class Tweet
{

	@Id
	private String id;
	private String text;
	private Date date;
	private String language;
	private String userName;

}
