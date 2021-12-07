package services;

import java.util.HashMap;

import dataStore.DB;
import interfaces.ICard;
import interfaces.IList;
import interfaces.IUser;
import interfaces.IUserService;
import models.ListT;
import models.User;

public class UserService implements IUserService {
	
	DB database;
	public UserService(DB database) {
		this.database = database;
	}
	
	@Override
	public IUser getUser(String userId) {
		return this.database.getUsers().get(userId);
	}
	
	@Override
	public IUser createUser(String Id, String Name, String Email) {
		IUser user = new User(Id, Name, Email);
		this.database.getUsers().put(user.getId(), user);
		return user;
	}

	@Override
	public IUser modifyUser(String userId, IUser user) {
		this.database.getUsers().put(userId, user);
		return this.database.getUsers().get(userId);
	}

	@Override
	public void deleteUser(String userId) {
		this.database.getUsers().remove(userId);
		return;
	}
}
