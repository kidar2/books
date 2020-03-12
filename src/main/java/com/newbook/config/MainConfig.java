package com.newbook.config;


import com.newbook.dao.BookDaoImpl;
import com.newbook.dao.UserDao;
import com.newbook.dao.UserDaoImpl;
import com.newbook.service.BookService;
import com.newbook.service.BookServiceImpl;
import com.newbook.service.UserService;
import com.newbook.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.context.WebApplicationContext;

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
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/books");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserDao getUserDao()
	{
		return new UserDaoImpl(getJdbcTemplate());
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserService getUserService()
	{
		System.out.println("getUserService");
		return new UserServiceImpl();
	}


	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public BookDaoImpl getBookDao()
	{
		return new BookDaoImpl(getJdbcTemplate());
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public BookService getBookService()
	{
		return new BookServiceImpl();
	}
}
