package org.elibrary.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.elibrary.doc.*;
import org.elibrary.user.*;

public class ObjectToTable {
	Database db = new Database();
	Connection conn = db.connect();
	Statement stmt;

	public void bookToTable(Book book) throws SQLException{
		String query = "INSERT INTO BOOK VALUES (1, " + book.getTitle() +", " + book.getUploadDate() + ", " + book.getPublisher() +
				", " + book.getDescription() + ", " + book.getPrivacy() + ", " + book.getTags() + ", " + book.getPagesCount() + 
				", " + book.getPdf() + ", " + book.getCollection().getId() + ", " + book.getPublisher() + ")";
		stmt = conn.createStatement();
		stmt.execute(query);
	}
	public void userToTable(User user){
		
	}
	public void authorToTable(Author author){
		
	}
	public void bookmarkToTable(Bookmark bookmark){
		
	}
}
