package com.newbook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Book
{
	private int id;
	private String name;
	private int[] autorIds;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	public int[] getAutorIds()
	{
		return autorIds;
	}

	public void setAutorIds(int[] autorIds)
	{
		this.autorIds = autorIds;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
