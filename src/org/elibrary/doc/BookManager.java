package org.elibrary.doc;

import java.sql.SQLException;
import java.util.HashMap;
import org.elibrary.db.*;

public class BookManager extends HashMap<Integer, Book> {
	TableToObject tto = new TableToObject();
	ObjectToTable ott = new ObjectToTable(); 

/*	public static void main(String args[]){
		DocumentManager dm = new DocumentManager();
		Document book = dm.getDocument(1);
		System.out.println(book.getId() + ", \"" + book.getTitle() + "\", \"" + book.getDescription() + "\", " + book.getPrivacy());
	}
*/	
	public BookManager(){
		Book book = tto.tableToBook(1);
		this.put(1, book);
	}
	
	public Book getBook(int id){
		return tto.tableToBook(id);
	}
	
	public void addBook(Book newBook){
		// TODO add the docment to the database and get the id
		try {
			ott.bookToTable(newBook);
			this.put(newBook.getId(), newBook);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void removeBook(int id){
		// TODO remove the docment from the database too
		this.remove(id);
	}
}
