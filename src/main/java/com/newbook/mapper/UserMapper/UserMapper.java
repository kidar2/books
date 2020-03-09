package com.newbook.mapper.UserMapper;

import com.newbook.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>
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
}
