package com.cleartrip.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleartrip.library.entities.Book;
import com.cleartrip.library.entities.Borrow;
import com.cleartrip.library.entities.User;

@Service
public class BorrowService {
	@Autowired
	BorrowRepository borrowRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;
	public List<Borrow> find(String emailId) {
		return borrowRepository.findAllByUserEmailId(emailId);
	}

	public List<Borrow> find(User user) {
		return borrowRepository.findAllByUser(user);
	}

	public List<Borrow> find(Book book) {
		return borrowRepository.findAllByBook(book);
	}

	public Borrow save(Borrow borrow) {
		System.out.println(borrow);
		borrow.setUser(userRepository.findByEmailId(borrow.getUser().getEmailId()));
		borrow.setBook(bookRepository.findByName(borrow.getBook().getName()));
		return borrowRepository.save(borrow);
	}

	public void update(Borrow borrow) {
		borrowRepository.save(borrow);
	}

	public void delete(int id) {
		borrowRepository.delete(borrowRepository.findOne(id));
	}

	public List<Borrow> findAll() {
		// TODO Auto-generated method stub
		return (List<Borrow>) borrowRepository.findAll();
	}
}
