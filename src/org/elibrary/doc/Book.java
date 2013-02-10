package org.elibrary.doc;

import java.io.File;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.elibrary.user.User;


public class Book {


/*	public static void main(String args[]){
		String methods = Book.class.getMethods()[0].toGenericString();
		String[] parsedList = methods.split(".", 7);
		System.out.println(parsedList[1]);
	}
*/
	private int author;
	private int publisher;
	private int id;
	private String title;
	private Blob thumbnail;
	private Date uploadDate;
	private String description = "";
	private Privacy privacy;
	private int pagesCount;
	private byte[] pdf = null;
	private String uploader;
	private String tags = "";
	private int category;

	
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getPublisher() {
		return publisher;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
