package com.newbook.dao;

import com.newbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		return jdbcTemplate.query("select * from users", new RowMapper<User>()
		{
			@Override
			public User mapRow(ResultSet resultSet, int i) throws SQLException
			{
				User u = new User();
				u.setId(resultSet.getInt("id"));
				u.setName(resultSet.getString("name"));
				u.setBirthday(resultSet.getDate("birthday"));
				return u;
			}
		});
	}

	@Override
	public int addUser(User user)
	{
		return jdbcTemplate.query("insert into users (name, birthday) values (?,?) returning id", new RowMapper<Integer>()
		{
			@Override
			public Integer mapRow(ResultSet resultSet, int i) throws SQLException
			{
				return resultSet.getInt("id");
			}
		}, new Object[]{user.getName(), user.getBirthday()}).get(0);
	}

	@Override
	public void removeUser(int id)
	{
		jdbcTemplate.execute("delete from users where id=" + id);
	}

	@Override
	public void updateUser(User user)
	{
		jdbcTemplate.update(
				  "update users set name=?, birthday =? where id=" + user.getId(),
				  new Object[]{user.getName(), user.getBirthday()}
		);
	}
}
