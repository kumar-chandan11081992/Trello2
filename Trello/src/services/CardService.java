package services;

import java.util.List;

import dataStore.DB;
import interfaces.ICard;
import interfaces.ICardService;
import interfaces.IList;
import interfaces.IUser;
import models.Card;

public class CardService implements ICardService{

	DB database;
	public CardService(DB database) {
		this.database = database;
	}
	
	public ICard getCard(String cardId) {
		return database.getCards().get(cardId);
	}
	
	@Override
	public ICard createCard(String name,String description, IUser assignedUser, String listId) {
		ICard card = new Card(name, description, assignedUser, listId);
		this.database.getCards().put(card.getId(), card);
		IList list = this.database.getLists().get(listId);
		list.getCards().put(card.getId(), card);
		this.database.getBoards().get(list.getBoardId()).getLists().put(listId, list);
		return card;
	}

	@Override
	public ICard assignMember(ICard card, IUser member) {
		card.setAssingedUser(member);
		return card;
	}

	@Override
	public ICard modifyCard(String cardId, ICard card) {
		this.database.getCards().put(card.getId(), card);
		IList list = this.database.getLists().get(card.getListId());
		list.getCards().put(card.getId(), card);
		this.database.getBoards().get(list.getBoardId()).getLists().put(card.getListId(), list);
		return card;
	}

	@Override
	public void deleteCard(String cardId) {
		ICard card = this.database.getCards().remove(cardId);
		this.database.getCards().remove(cardId);
		IList list = this.database.getLists().get(card.getListId());
		list.getCards().remove(cardId);
		this.database.getBoards().get(list.getBoardId()).getLists().put(card.getListId(), list);
		return;	
	}

}
