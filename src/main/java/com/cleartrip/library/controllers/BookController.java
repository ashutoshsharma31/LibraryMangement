package com.cleartrip.library.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cleartrip.library.entities.Book;
import com.cleartrip.library.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	BookService bookService;

	// Get All Books
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}
	
	// Create a new Book
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		System.out.println(book);
	    return bookService.save(book);
	}
	
	// Create a new Book
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteBook(@RequestBody Book book) {
		System.out.println(book);
	    bookService.delete(book);
	}
}
