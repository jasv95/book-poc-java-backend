package com.jas.poc.demo.Entity;

import java.util.Set;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@ManyToMany
	@JoinTable(
			name = "books_liked", // name of the joined table
			joinColumns = @JoinColumn(name = "user_id"), // tbname_pk
			inverseJoinColumns = @JoinColumn(name = "books_id") // foreign_tbname_pk
			)
	@JsonIgnore
	Set<Book> linkedBooks;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Set<Book> getLinkedBooks() {
		return linkedBooks;
	}

	public void setLinkedBooks(Set<Book> linkedBooks) {
		this.linkedBooks = linkedBooks;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
