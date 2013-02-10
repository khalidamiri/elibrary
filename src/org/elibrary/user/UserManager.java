package org.elibrary.user;

import java.sql.SQLException;
import java.util.HashMap;

import org.elibrary.db.ObjectToTable;
import org.elibrary.db.TableToObject;

public class UserManager extends HashMap<String, User> implements UserManagerInterface {

	TableToObject tto = new TableToObject();
	ObjectToTable ott = new ObjectToTable();

	public UserManager(){
		// TODO load users from the database
	}
	
	public void addUser(User newUser) {
		this.put(newUser.getUserName(), newUser);
		try {
			ott.userToTable(newUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public User getUser(int userName) {
		// TODO get the user from database
		return null;
	}

	public void removeUser(int userName) {
		// TODO remove the user from database too

		if(this.containsKey(userName)){
			this.remove(userName);
		}
	}
	
	public User authenticateUser(String userName, String password){
		return tto.tableToUser(userName, password);
	}
	
	public boolean validateUser(String username){
		return tto.doesExist(username, "user", "userName");
	}

}
