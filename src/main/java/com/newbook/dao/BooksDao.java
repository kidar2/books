package com.newbook.dao;

import com.newbook.entity.Book;


import java.util.List;

public interface BooksDao
{
	List<Book> getBooks();

	int addBook(Book book);

	void removeBook(int id);

	void updateBook(Book book);
}
