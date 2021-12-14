package com.jas.poc.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jas.poc.demo.Entity.Book;
import com.jas.poc.demo.Entity.User;
import com.jas.poc.demo.services.BookService;
import com.jas.poc.demo.services.UserService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("getAll")
	public List<Book> getAllBooks(){
		return bookService.findAll();
	}

	@GetMapping("getAllFavourite")
	public Set<Book> getAllFavourite(@RequestParam(name="userName") String userName){
		User user = userService.findByName(userName);
		return user.getLinkedBooks();
	}
	
	@PostMapping("addToFavourite")
	public void addToFavourite(@RequestBody Map<String, Object> payload) {
		Long bookId = new Long((Integer) payload.get("bookId"));
		String userName = (String) payload.get("userName");
		
		Optional<Book> book = bookService.findById(bookId);
		User user = userService.findByName(userName);
		
		book.get().getLinkedUser().add(user);
		user.getLinkedBooks().add(book.get());

		userService.save(user);
	}
	
	@PostMapping("removeBookFromFavourite")
	public void removeBookFromFavourite(@RequestBody Map<String, Object> payload) {
		Long bookId = new Long((Integer) payload.get("bookId"));
		String userName = (String) payload.get("userName");
		
		Optional<Book> book = bookService.findById(bookId);
		User user = userService.findByName(userName);
		
		book.get().getLinkedUser().remove(user);
		user.getLinkedBooks().remove(book.get());

		userService.save(user);
	}
}
