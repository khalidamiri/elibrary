package org.elibrary.doc;

public interface DocumentManagerInterface {

	public Document getDocument(int id);
	public void addDocument(Document newDoc);
	public void removeDocument(int id);
}
