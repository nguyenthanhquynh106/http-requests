package com.example.book.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.IBookService;

@Service
public class BookService implements IBookService {
	private IBookRepository bookRepository;

	@Autowired
	public BookService(IBookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	@Transactional
	public void insert(Book b) {
		bookRepository.insert(b);
	}

	@Override
	public Book findById(long id) {
		return bookRepository.findById(id);
	}

}
