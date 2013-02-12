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
		Category category= new Category();
		category.setId(1);
		book.setId(1);
		book.setCategory(category.getId());

		String query = "INSERT INTO BOOK (name, uploadDate, publishYear, description, privacy, tags, readCount, " +
				"pagesCount, file, category, uploader, publisher)" +
				" VALUES (\"" + book.getTitle() +"\", \"2010-10-10\", 2011" +
				", \"" + book.getDescription() + "\", \"" + book.getPrivacy() + "\", \"" + book.getTags() + "\", 10, " + book.getPagesCount() + 
				", ?, " + book.getCategory() + ", 'khalid', \"" + book.getPublisher() + "\")";
				System.out.println(query);
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setBytes(1, book.getPdf());
		pstmt.executeUpdate();
	}
	public void userToTable(User user) throws SQLException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String query = "INSERT INTO CATEGORY (userName, dateJoined, readCount, email, password, firstName, lastName) VALUES (\"" + user.getUserName() + "\", \"" + dateFormat.format(user.getDateJoined()) + "\", 0, \"" + user.getEmail() +
				"\", \"" + user.getPassword() + "\", \"" + user.getFirstName() + "\", \"" + user.getLastName() + "\")";
		System.out.println(query);
		stmt = conn.createStatement();
		stmt.execute(query);
	}
	public void authorToTable(Author newAuthor){
		String query = "INSERT INTO AUTHOR (name, bio) VALUES (\"" + newAuthor.getName() + "\", \"" + newAuthor.getBio() + "\")";
		System.out.println(query);
		try {
			stmt = conn.createStatement();
			stmt.execute(query);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bookmarkToTable(Bookmark bookmark){
		
	}
	public void categoryToTable(Category newCategory) {
		String query = "INSERT INTO CATEGORY (name, description) VALUES (\"" + newCategory.getName() + "\", \"" + newCategory.getDescription() + "\")";
		System.out.println(query);
		try {
			stmt = conn.createStatement();
			stmt.execute(query);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addCategory(Publisher newPub) {
		String query = "INSERT INTO PUBLISHER (pubName, pubDesc) VALUES (\"" + newPub.getName() + "\", \"" + newPub.getDescription() + "\")";
		System.out.println(query);
		try {
			stmt = conn.createStatement();
			stmt.execute(query);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
