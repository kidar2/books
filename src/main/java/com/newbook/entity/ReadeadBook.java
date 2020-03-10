package com.newbook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ReadeadBook extends Book
{
	private int userId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;

	private int idea;
	private int scenario;
	private int theFinal;

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public int getIdea()
	{
		return idea;
	}

	public void setIdea(int idea)
	{
		this.idea = idea;
	}

	public int getScenario()
	{
		return scenario;
	}

	public void setScenario(int scenario)
	{
		this.scenario = scenario;
	}

	public int getTheFinal()
	{
		return theFinal;
	}

	public void setTheFinal(int theFinal)
	{
		this.theFinal = theFinal;
	}


}
