package com.cleartrip.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleartrip.library.entities.Book;
import com.cleartrip.library.entities.User;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public Book find(String name) {
		return bookRepository.findByName(name);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void update(Book book) {
		bookRepository.save(book);
	}

	public void delete(int id) {
		bookRepository.delete(bookRepository.findOne(id));
	}

	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return (List<Book>) bookRepository.findAll();
	}

	public void delete(Book book) {
		bookRepository.delete(book);
	}
}
