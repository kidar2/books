package com.newbook.dao;

import com.newbook.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BooksDao
{

	public final JdbcTemplate jdbcTemplate;

	@Autowired
	public BookDaoImpl(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> getBooks()
	{
		return jdbcTemplate.query("select * from books", new BookMapper());
	}

	@Override
	public int addBook(Book book)
	{
		return jdbcTemplate.query("insert into books (name, date, genre) values (?,?,?) returning id", new RowMapper<Integer>()
		{
			@Override
			public Integer mapRow(ResultSet resultSet, int i) throws SQLException
			{
				return resultSet.getInt("id");
			}
		}, book.getName(), book.getDate(), book.getGenre()).get(0);
	}

	@Override
	public void removeBook(int id)
	{
		jdbcTemplate.execute("delete from books where id=" + id);
	}

	@Override
	public void updateBook(Book book)
	{
		jdbcTemplate.update(
				  "update users set name=?, date =?, genre=? where id=" + book.getId(),
				  book.getName(), book.getDate(), book.getGenre());
	}

	public static class BookMapper implements RowMapper<Book>
	{

		@Override
		public Book mapRow(final ResultSet resultSet, int i) throws SQLException
		{
			return new Book()
			{{
				setId(resultSet.getInt("id"));
				setName(resultSet.getString("name"));
				setDate(resultSet.getDate("date"));
				setGenre(resultSet.getString("genre"));
			}};
		}
	}
}
