package org.elibrary.doc;

import java.io.File;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.elibrary.user.User;


public class Book {


	public static void main(String args[]){
		String methods = Book.class.getMethods()[0].toGenericString();
		String[] parsedList = methods.split(".", 7);
		System.out.println(parsedList[1]);
	}
	// TODO later change the type of author to AuthorInterface
	private String author;
	// TODO later change the type of publisher to PublisherInterface
	private String publisher;
	private int id;
	private String title;
	private Blob thumbnail;
	private Date uploadDate;
	private String description = "";
	private Privacy privacy;
	private int pagesCount;
	private byte[] pdf = null;
	private User uploader;
	private String tags = "";
	private Collection collection;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle(){
		return this.title;
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
