package com.jas.poc.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jas.poc.demo.Entity.Book;
import com.jas.poc.demo.Entity.User;
import com.jas.poc.demo.repository.BookRepository;
import com.jas.poc.demo.repository.UserRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Book> findByName(String name){
		return bookRepository.findByName(name);
	}
	
	public List<Book> findAll(){
		return (List<Book>) bookRepository.findAll();
	}
	
	public Optional<Book> findById(Long id){
		return bookRepository.findById(id);
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
}
