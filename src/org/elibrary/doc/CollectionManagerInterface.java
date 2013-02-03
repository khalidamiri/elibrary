package org.elibrary.doc;

import java.util.List;

public interface CollectionManagerInterface {

	public List listCollections();
	public Collection getCollection(int collId);
	public void removeCollection(int collId);
	public void addCollection(Collection newCollection);
}
