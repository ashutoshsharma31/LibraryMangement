package com.cleartrip.library.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cleartrip.library.entities.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}