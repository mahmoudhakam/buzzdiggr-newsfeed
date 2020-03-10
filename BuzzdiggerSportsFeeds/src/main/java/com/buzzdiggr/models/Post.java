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
public class Post
{

	private String id;
	private String text;
	private Date date;
	private String language;
	private String userName;
}
