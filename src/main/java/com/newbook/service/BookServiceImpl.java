package com.newbook.service;

import com.newbook.dao.BooksDao;
import com.newbook.dao.UserDao;
import com.newbook.entity.Book;
import com.newbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{

	@Autowired
	public BooksDao bookDao;


	@Override
	public List<Book> getBooks()
	{
		return bookDao.getBooks();
	}

	@Override
	public int addBook(Book book)
	{
		return bookDao.addBook(book);
	}

	@Override
	public void removeBook(int id)
	{
		bookDao.removeBook(id);
	}

	@Override
	public void updateBook(Book book)
	{
		bookDao.updateBook(book);
	}
}
