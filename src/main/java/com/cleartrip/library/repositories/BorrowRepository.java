package com.cleartrip.library.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cleartrip.library.entities.Book;
import com.cleartrip.library.entities.Borrow;
import com.cleartrip.library.entities.User;
@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Integer> {

	public List<Borrow> findAllByUserEmailId(String emailId);

	public List<Borrow> findAllByUser(User user);

	public List<Borrow> findAllByBook(Book book);

}