package org.elibrary.doc;

public interface DocumentManagerInterface {

	public Book getBook(int id);
	public void addBook(Book newBook);
	public void removeBook(int id);
}
