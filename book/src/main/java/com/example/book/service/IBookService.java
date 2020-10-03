package com.example.book.service;

import com.example.book.model.Book;

public interface IBookService {
	public void insert(Book b);

	public Book findById(long id);
}
