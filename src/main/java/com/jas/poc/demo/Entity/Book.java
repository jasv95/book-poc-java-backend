package com.jas.poc.demo.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="books")
public class Book {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;
	
	@Column
	private String author;
	
	@ManyToMany(mappedBy = "linkedBooks") // Foreign variable name
	@JsonIgnore
	Set<User> linkedUser;

	public Long getId() {
		return id;
	}
	
	public Set<User> getLinkedUser() {
		return linkedUser;
	}

	public void setLinkedUser(Set<User> linkedUser) {
		this.linkedUser = linkedUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
