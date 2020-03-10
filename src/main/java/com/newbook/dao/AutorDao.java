package com.newbook.dao;

import com.newbook.entity.Autor;
import com.newbook.entity.Book;

import java.util.List;

public interface AutorDao
{
	List<Autor> getAutors();

	int addAutor(Autor user);

	void removeAutor(int id);

	void updateAutor(Autor user);
}
