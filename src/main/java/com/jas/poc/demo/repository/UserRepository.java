package com.jas.poc.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.jas.poc.demo.Entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByName(String name);
	Optional<User> findById(Long id);
}
