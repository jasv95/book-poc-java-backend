package com.jas.poc.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jas.poc.demo.Entity.Book;
import com.jas.poc.demo.Entity.User;
import com.jas.poc.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public Optional<User> findById(Long id){
		return userRepository.findById(id);
	}
	
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

}
