package org.elibrary.doc;

import java.util.List;

public abstract class Collection {
	
	private int Id;
	private String name;
	private String Description;
	private List<Document> documents = null;

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
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
