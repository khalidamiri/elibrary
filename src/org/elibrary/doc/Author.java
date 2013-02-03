package org.elibrary.doc;

public class Author implements AuthorInterface{

	private String name;
	private String bio;

	public Author(String name, String bio){
		this.setName(name);
		this.setBio(bio);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
}
