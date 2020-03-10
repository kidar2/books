package com.newbook.controller;

import com.newbook.entity.Book;
import com.newbook.entity.User;
import com.newbook.service.BookService;
import com.newbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController
{
	@Autowired
	public BookService bookService;



	@GetMapping("/books")
	@ResponseBody
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}


	@PostMapping("/books")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody Book book)
	{
		bookService.addBook(book);
	}

	@PostMapping("/books/{bookId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateUser(@PathVariable Integer bookId, @RequestBody Book book)
	{
		book.setId(bookId);
		bookService.updateBook(book);
	}

	@DeleteMapping("/books/{bookId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Integer bookId)
	{
		bookService.removeBook(bookId);
	}
}
