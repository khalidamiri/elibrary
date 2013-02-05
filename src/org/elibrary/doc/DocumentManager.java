package org.elibrary.doc;

import java.util.HashMap;
import org.elibrary.db.*;

public class DocumentManager extends HashMap<Integer, Document> implements DocumentManagerInterface{
	TableToObject too = new TableToObject();

/*	public static void main(String args[]){
		DocumentManager dm = new DocumentManager();
		Document book = dm.getDocument(1);
		System.out.println(book.getId() + ", \"" + book.getTitle() + "\", \"" + book.getDescription() + "\", " + book.getPrivacy());
	}
*/	
	public DocumentManager(){
		Book book = too.tableToBook(1);		
		this.put(1, book);
	}
	
	public Document getDocument(int id){
		return this.get(id);
	}
	
	public void addDocument(Document newDoc){
		// TODO add the docment to the database and get the id
		
		this.put(newDoc.getId(), newDoc);
	}

	public void removeDocument(int id){
		// TODO remove the docment from the database too
		this.remove(id);
	}
}
