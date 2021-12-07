package services;

import java.util.HashMap;
import java.util.List;

import dataStore.DB;
import interfaces.ICard;
import interfaces.IList;
import interfaces.IListService;
import models.Card;
import models.ListT;

public class ListService implements IListService {
	
	DB database;
	public ListService(DB database) {
		this.database = database;
	}
	
	public IList getList(String listId) {
		return this.database.getLists().get(listId);
	}
	@Override
	public IList createList(String name, HashMap<String,ICard> cards, String boardId) {
		IList list = new ListT(name, cards, boardId);
		this.database.getLists().put(list.getId(), list);
		this.database.getBoards().get(list.getBoardId()).getLists().put(list.getId(), list);
		return list;
	}

	@Override
	public IList modifyList(String listId, IList list) {
		this.database.getLists().put(list.getId(), list);
		this.database.getBoards().get(list.getBoardId()).getLists().put(list.getId(), list);
		return list;
	}

	@Override
	public void deleteList(String listId) {
		IList list = this.database.getLists().get(listId);
		this.database.getLists().remove(listId);
		this.database.getBoards().get(list.getBoardId()).getLists().remove(listId);
		return;
	}

}
