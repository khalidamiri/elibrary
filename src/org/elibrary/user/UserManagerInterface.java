package org.elibrary.user;

public interface UserManagerInterface {

	public void addUser(User newUser);
	public User getUser(int userName);
	public void removeUser(int userName);
}
