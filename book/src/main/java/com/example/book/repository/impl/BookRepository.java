package com.example.book.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;

@Repository
public class BookRepository implements IBookRepository {
	private EntityManager em;

	@Autowired
	public BookRepository(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insert(Book b) {
		em.persist(b);
	}

	@Override
	public Book update(Book b) {
		return em.merge(b);
	}

	@Override
	public Book findById(long id) {
		return em.find(Book.class, id);
	}

}
