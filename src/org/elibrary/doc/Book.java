package org.elibrary.doc;

public class Book extends Document {

	// TODO later change the type of author to AuthorInterface
	private String author;
	// TODO later change the type of publisher to PublisherInterface
	private String publisher;
	
	public String getTitle(){
		return super.getTitle();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
