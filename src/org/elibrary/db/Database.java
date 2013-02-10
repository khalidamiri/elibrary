package org.elibrary.db;
import java.sql.*;

public class Database {

	Drivers dbd = new Drivers();
	private String connStr = "jdbc:mysql://localhost:3306/elibrary";
	private Connection conn = null;
	private String user = "root";
	private String pw = "";
	

/*	public static void main(String[] args){
		Database db = new Database();
		System.out.println(db.connect());
	}
*/	
	public Connection connect(){
		
		try {
			// Load the driver
			Class.forName(dbd.get("mysql-native"));
	
			// Create connection
			conn = DriverManager.getConnection(connStr, user, null);
			
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
}
