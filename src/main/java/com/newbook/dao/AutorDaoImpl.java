package com.newbook.dao;

import com.newbook.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AutorDaoImpl implements AutorDao
{
	public final JdbcTemplate jdbcTemplate;

	@Autowired
	public AutorDaoImpl(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Autor> getAutors()
	{
		return jdbcTemplate.query("select * from authors", new AutorMapper());
	}

	@Override
	public int addAutor(Autor user)
	{
		return jdbcTemplate.query("insert into authors (name, birthday, country) values (?,?,?) returning id", new RowMapper<Integer>()
		{
			@Override
			public Integer mapRow(ResultSet resultSet, int i) throws SQLException
			{
				return resultSet.getInt("id");
			}
		}, new Object[]{user.getName(), user.getBirthday(), user.getCountry()}).get(0);
	}

	@Override
	public void removeAutor(int id)
	{
		jdbcTemplate.execute("delete from authors where id=" + id);
	}

	@Override
	public void updateAutor(Autor user)
	{
		jdbcTemplate.update(
				  "update authors set name=?, birthday =?, country=? where id=" + user.getId(),
				  new Object[]{user.getName(), user.getBirthday(), user.getCountry()}
		);
	}

	public static class AutorMapper implements RowMapper<Autor>
	{
		@Override
		public Autor mapRow(final ResultSet resultSet, int i) throws SQLException
		{
			return new Autor()
			{{
				setId(resultSet.getInt("id"));
				setName(resultSet.getString("name"));
				setBirthday(resultSet.getDate("birthday"));
				setCountry(resultSet.getString("country"));
			}};
		}
	}
}
