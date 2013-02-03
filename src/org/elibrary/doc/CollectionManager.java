package org.elibrary.doc;

import java.util.List;
import java.util.HashMap;

public class CollectionManager extends HashMap<Integer, Collection> implements CollectionManagerInterface{


	public CollectionManager(){
		// TODO get the list of collections from database
		
	}
		
	public List listCollections() {
		return (List) this.values();
	}

	public Collection getCollection(int collId) {
		// TODO get collection object from database by its id
		return this.get(collId);
	}

	public void removeCollection(int collId) {
		// TODO remove a collection from the database too
		this.remove(collId);
	}

	public void addCollection(Collection newCollection) {
		// TODO add the new collection to the database too 
		this.put(newCollection.getId(), newCollection);
	}

}
