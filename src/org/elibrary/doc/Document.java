package org.elibrary.doc;

import java.util.List;
import org.elibrary.doc.Privacy;
import org.elibrary.user.User;
import java.sql.Blob;
import java.util.Date;

public abstract class Document {

	private int id;
	private String title;
	private Blob thumbnail;
	private Date uploadDate;
	private String description = "";
	private Privacy privacy;
	private int pagesCount;
	private Blob pdf = null;
	private User uploader;
	private String tags = "";
	private List<Bookmark> bookmarks;
	private Collection collection;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Blob getPdf() {
		return pdf;
	}
	public void setpdf(Blob pdf) {
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
	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}
	public Blob getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Collection getCollection() {
		return collection;
	}
	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
