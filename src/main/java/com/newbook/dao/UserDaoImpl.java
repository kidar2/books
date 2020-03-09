package com.newbook.dao;

import com.newbook.entity.User;
import com.newbook.mapper.UserMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao
{

	public final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> getUsers()
	{
		return jdbcTemplate.query("select * from users", new UserMapper());
	}
}
