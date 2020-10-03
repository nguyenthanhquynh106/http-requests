package com.example.book.repository;

import com.example.book.model.Book;

public interface IBookRepository {
	public void insert(Book b);

	public Book update(Book b);

	public Book findById(long id);
}
