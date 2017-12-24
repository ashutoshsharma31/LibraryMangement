package com.cleartrip.library.services;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cleartrip.library.entities.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	public List<Book> findAllByName(String name);

}