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

import com.cleartrip.library.entities.Borrow;
import com.cleartrip.library.services.BorrowService;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
	@Autowired
	BorrowService borrowService;

	// Get All Borrows
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Borrow> getAllBorrows() {
		return borrowService.findAll();
	}
	
	// Create a new Borrow
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Borrow createBorrow(@RequestBody Borrow borrow) {
		System.out.println(borrow);
	    return borrowService.save(borrow);
	}
	
	// Create a new Borrow
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteBorrow(@RequestBody int id) {
		System.out.println(id);
	    borrowService.delete(id);
	}
}
