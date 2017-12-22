package com.cleartrip.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cleartrip.library.entities.Borrow;
@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Integer> {

}