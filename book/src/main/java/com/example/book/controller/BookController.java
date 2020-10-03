package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.model.Book;
import com.example.book.rest.model.CreateBookRequest;
import com.example.book.rest.model.UpdateBookRequest;
import com.example.book.service.IBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private IBookService bookService;

	@Autowired
	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/insert/name/{name}")
	public Book insertBook(@PathVariable String name) {
		Book book = new Book();
		book.setName(name);
		bookService.insert(book);
		return book;
	}

	@GetMapping("/{bookId}")
	public Book findById(@PathVariable long bookId) {
		return bookService.findById(bookId);
	}

	@GetMapping("/insert")
	public Book inseBook(@RequestParam String name) {
		Book book = new Book();
		book.setName(name);
		bookService.insert(book);
		return book;
	}

	@PostMapping("/story")
	public String postBook(@RequestBody CreateBookRequest restBook) {
		return String.format("Book has name: %s", restBook.getName());
	}

	@PutMapping("/{bookId}")
	public String update(@PathVariable long bookId, @RequestBody UpdateBookRequest restBook) {
		return String.format("Book has id: %d and new type: %s", bookId, restBook.getType());
	}

	@DeleteMapping
	public String delete(@RequestBody long id) {
		return String.format("Deleted book with id is %d success", id);
	}
}
