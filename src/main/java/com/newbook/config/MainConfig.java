package com.newbook.config;


import com.newbook.dao.UserDao;
import com.newbook.dao.UserDaoImpl;
import com.newbook.service.UserService;
import com.newbook.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MainConfig
{

	@Bean
	public JdbcTemplate getJdbcTemplate()
	{
		return new JdbcTemplate(getDataSource());
	}

	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/books");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}

	@Bean
	public UserDao getUserDao()
	{
		return new UserDaoImpl(getJdbcTemplate());
	}

	@Bean
	public UserService getUserService()
	{
		return new UserServiceImpl();
	}
}
