package com.jas.poc.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jas.poc.demo.Entity.Book;


public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByName(String name);
	Optional<Book> findById(Long id);

}
