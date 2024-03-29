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

/*	public static void main(String args[]){
		TableToObject tto = new TableToObject();
		User user1 = tto.tableToUser(1, "password");
		System.out.println(user1.getFirstName() + " " + user1.getLastName());
	}
*/
	public Book tableToBook(int bookId){
		String query = "SELECT * FROM book WHERE idBook = " + bookId;
		Book book = new Book();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				book.setTitle(rs.getString("name"));
//				book.setAuthor(rs.getInt("author"));
				book.setPublisher(rs.getInt("publisher"));
//				book.setThumbnail(rs.getBytes());	// TODO Update this to generating thumbnail from the pdf
				book.setUploadDate(rs.getDate("uploadDate"));
				book.setDescription(rs.getString("description"));
				book.setPrivacy(null);		// TODO convert the privacy string returned from the table to type Privacy
				Blob blob = rs.getBlob("file");
				book.setPdf(blob.getBytes(1, (int)blob.length()));
				book.setUploader(rs.getString("uploader"));		// TODO change the null
				book.setTags(rs.getString("tags"));	
				// TODO the book mark should be generated in here
				book.setCategory(rs.getInt("category"));		// TODO change the null
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	public User tableToUser(String userName, String password){
		String query = "SELECT * FROM user WHERE userName = \"" + userName + "\" and password = \"" + password + "\";";
		System.out.println(query);
		User user = new User();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				user.setUserName(rs.getString("userName"));
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
	
	public boolean doesExist(String item, String table, String col){
		String query = "SELECT " + col + " FROM " + table + " WHERE " + col + " = \"" + item + "\"";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next()){
				System.out.println(rs);
				System.out.println(rs.getString(1));
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	}
	public StringBuffer getList(String listName) {
		String tableName = "";
		String id = "";
		String name = "";
		System.out.println(listName);
		if(listName.equals("category")){
			tableName="category";
			id="idCATEGORY";
			name="name";
		}else if(listName.equals("publisher")){
			tableName="publisher";
				id="idPUBLISHER";
				name="pubName";
		}else if(listName.equals("author")){
			tableName="author";
			id="idAuthor";
			name="name";
		}else{
			tableName = "";
			id = "";
			name = "";
		}
		System.out.println(id + " " + name);
		String query = "SELECT " + id + ", " + name + " FROM " + tableName;
		System.out.println(query);
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			StringBuffer sb = new StringBuffer();
			String delim = "";
			while(rs.next()){
				sb.append(delim);
				sb.append("" + rs.getInt(1) + " - " + rs.getString(2) + "");
				delim = ",";
			}
			System.out.println(sb);
			return sb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
