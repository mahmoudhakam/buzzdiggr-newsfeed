package com.buzzdiggr.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "schools", type = "_doc")
public class Schools
{
	@Id
	private String id;
	private String name;
	private String description;
	private String street;
	private String city;
	private String state;
	private String zip;
	private List<String> location;
	private List<String> tags;
	private String fees;
	private String rating;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	public List<String> getLocation()
	{
		return location;
	}
	public void setLocation(List<String> location)
	{
		this.location = location;
	}
	public List<String> getTags()
	{
		return tags;
	}
	public void setTags(List<String> tags)
	{
		this.tags = tags;
	}
	public String getFees()
	{
		return fees;
	}
	public void setFees(String fees)
	{
		this.fees = fees;
	}
	public String getRating()
	{
		return rating;
	}
	public void setRating(String rating)
	{
		this.rating = rating;
	}
	
	public Schools()
	{
	}

}
