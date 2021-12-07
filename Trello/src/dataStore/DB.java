package dataStore;

import java.util.HashMap;

import interfaces.IBoard;
import interfaces.ICard;
import interfaces.IList;
import interfaces.IUser;

public class DB {
HashMap<String, IBoard> boards;
HashMap<String, ICard> cards;
HashMap<String, IList> lists;
HashMap<String, IUser> users;

private static DB database;

private DB() {
}

public static DB getInstance() {
	if(database == null)
		database = new DB();
	return database;
}

public HashMap<String, IBoard> getBoards(){
	DB db = DB.getInstance();
	return db.boards;
}

public HashMap<String, ICard> getCards(){
	DB db = DB.getInstance();
	return db.cards;
}

public HashMap<String, IList> getLists(){
	DB db = DB.getInstance();
	return db.lists;
}

public HashMap<String, IUser> getUsers(){
	DB db = DB.getInstance();
	return db.users;
}
}
