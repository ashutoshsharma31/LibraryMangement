package com.cleartrip.library.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cleartrip.library.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmailId(String emailId);

}