package com.cleartrip.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleartrip.library.entities.Book;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public List<Book> find(String name) {
		return bookRepository.findAllByName(name);
	}
	public void save(Book book) {
		bookRepository.save(book);
	}
	public void update(Book book) {
		bookRepository.save(book);
	}
	public void delete(Book book) {
		bookRepository.delete(book);
	}
}
