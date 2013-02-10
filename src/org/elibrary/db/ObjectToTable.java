package org.elibrary.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.elibrary.doc.*;
import org.elibrary.user.*;

public class ObjectToTable {
	Database db = new Database();
	Connection conn = db.connect();
	Statement stmt;

	public void bookToTable(Book book) throws SQLException{
		Collection collection = new Category();
		collection.setId(1);
		book.setId(1);
		book.setCollection(collection);

		String query = "INSERT INTO BOOK (name, uploadDate, publishYear, description, privacy, tags, readCount, " +
				"pagesCount, file, category, uploader, publisher)" +
				" VALUES (\"" + book.getTitle() +"\", \"2010-10-10\", 2011" +
				", \"" + book.getDescription() + "\", \"" + book.getPrivacy() + "\", \"" + book.getTags() + "\", 10, " + book.getPagesCount() + 
				", ?, " + book.getCollection().getId() + ", 'khalid', \"" + book.getPublisher() + "\")";
				System.out.println(query);
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setBytes(1, book.getPdf());
		pstmt.executeUpdate();
	}
	public void userToTable(User user) throws SQLException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String query = "INSERT INTO USER (userName, dateJoined, readCount, email, password, firstName, lastName) VALUES (\"" + user.getUserName() + "\", \"" + dateFormat.format(user.getDateJoined()) + "\", 0, \"" + user.getEmail() +
				"\", \"" + user.getPassword() + "\", \"" + user.getFirstName() + "\", \"" + user.getLastName() + "\")";
		stmt = conn.createStatement();
		stmt.execute(query);
	}
	public void authorToTable(Author author){
		
	}
	public void bookmarkToTable(Bookmark bookmark){
		
	}
}
