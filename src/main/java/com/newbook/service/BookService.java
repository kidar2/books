package com.newbook.service;

import com.newbook.entity.Book;

import java.util.List;

public interface BookService
{
	List<Book> getBooks();

	int addBook(Book book);

	void removeBook(int id);

	void updateBook(Book book);

}
