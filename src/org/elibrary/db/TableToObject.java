package org.elibrary.db;

import org.elibrary.doc.Author;
import java.sql.*;

import org.elibrary.doc.Book;
import org.elibrary.doc.Bookmark;
import org.elibrary.doc.Privacy;
import org.elibrary.user.User;

public class TableToObject {
	Database db = new Database();
	Connection conn = db.connect();
	Statement stmt;

	public static void main(String args[]){
		TableToObject tto = new TableToObject();
		User user1 = tto.tableToUser(1, "password");
		System.out.println(user1.getFirstName() + " " + user1.getLastName());
	}

	public Book tableToBook(int bookId){
		String query = "SELECT * FROM book WHERE idBook = " + bookId;
		Book book = new Book();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				book.setTitle(rs.getString("name"));
//				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
//				book.setThumbnail(rs.getBlob(null));	// TODO Update this to generating thumbnail from the pdf
//				book.setUploadDate(rs.getDate("uploadDate"));
				book.setDescription(rs.getString("description"));
				book.setPrivacy(null);		// TODO convert the privacy string returned from the table to type Privacy
//				book.setpdf(rs.getBlob("pdf"));
				book.setUploader(null);		// TODO change the null
				book.setTags(rs.getString("tags"));	
				// TODO the book mark should be generated in here
				book.setCollection(null);		// TODO change the null
			}
			this.closeConnection(stmt, rs, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	public User tableToUser(int userName, String password){
		String query = "SELECT * FROM user WHERE userName = " + userName + " and password = \"" + password + "\";";
		System.out.println(query);
		User user = new User();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				user.setUserName(rs.getInt("userName"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
			}
			this.closeConnection(stmt, rs, conn);
			System.out.println(user.getUserName() + " " + user.getLastName());
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The user does not exist.");
			e.printStackTrace();
			return null;
		}
	}
	public Author tableToAuthor(int authorId){
		return null;
	}
	public Bookmark tableToBookmark(int bookmarkId){
		return null;
	}
	
	public void closeConnection(Statement stmt, ResultSet rs, Connection conn) throws SQLException{
		stmt.close();
		rs.close();
		conn.close();
	}
}
