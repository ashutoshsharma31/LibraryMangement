package com.cleartrip.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleartrip.library.entities.Book;
import com.cleartrip.library.entities.Borrow;
import com.cleartrip.library.entities.User;
import com.cleartrip.library.repositories.BorrowRepository;

@Service
public class BorrowService {
	@Autowired
	BorrowRepository borrowRepository;

	public List<Borrow> find(String emailId) {
		return borrowRepository.findAllByUserEmailId(emailId);
	}

	public List<Borrow> find(User user) {
		return borrowRepository.findAllByUser(user);
	}

	public List<Borrow> find(Book book) {
		return borrowRepository.findAllByBook(book);
	}

	public void save(Borrow borrow) {
		borrowRepository.save(borrow);
	}

	public void update(Borrow borrow) {
		borrowRepository.save(borrow);
	}

	public void delete(Borrow borrow) {
		borrowRepository.delete(borrow);
	}
}
