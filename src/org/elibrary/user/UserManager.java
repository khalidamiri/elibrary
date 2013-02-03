package org.elibrary.user;

import java.util.HashMap;

import org.elibrary.db.TableToObject;

public class UserManager extends HashMap<Integer, User> implements UserManagerInterface {


	public UserManager(){
		// TODO load users from the database
	}
	
	public void addUser(User newUser) {
		// TODO add the user to database
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
	
	public User authenticateUser(int userName, String password){
		TableToObject tto = new TableToObject();
		return tto.tableToUser(userName, password);
	}

}
