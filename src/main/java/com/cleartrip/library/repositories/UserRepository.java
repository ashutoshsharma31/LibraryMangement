package com.cleartrip.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cleartrip.library.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findAllByEmailId(String emailId);

}