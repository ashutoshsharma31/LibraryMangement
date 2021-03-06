package com.cleartrip.library.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.cleartrip.library.utilities.*;

@Entity
public class Borrow {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private User user;
	@OneToOne
	private Book book;
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@Temporal(TemporalType.DATE)
	private Date borrowDate;
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", user=" + user + ", book=" + book + ", borrowDate=" + borrowDate + ", returnDate="
				+ returnDate + "]";
	}

}
