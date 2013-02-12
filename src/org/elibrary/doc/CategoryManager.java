package org.elibrary.doc;

import java.util.List;
import java.util.HashMap;

import org.elibrary.db.ObjectToTable;

public class CategoryManager extends HashMap<Integer, Category>{

	ObjectToTable ott = new ObjectToTable();

	public CategoryManager(){
		// TODO get the list of collections from database
		
	}
		
	public List listCollections() {
		return (List) this.values();
	}

	public Category getCategory(int catId) {
		// TODO get collection object from database by its id
		return this.get(catId);
	}

	public void removeCategory(int catId) {
		// TODO remove a collection from the database too
		this.remove(catId);
	}

	public void addCategory(Category newCategory) {
		// TODO add the new collection to the database too 
		ott.categoryToTable(newCategory);
		this.put(newCategory.getId(), newCategory);
	}

}
