package org.elibrary.doc;

import java.util.List;

public class Category {
	
	private int Id;
	private String name;
	private String Description;
	private List<Book> Books = null;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<Book> getBooks() {
		return Books;
	}
	public void setBooks(List<Book> Books) {
		this.Books = Books;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
