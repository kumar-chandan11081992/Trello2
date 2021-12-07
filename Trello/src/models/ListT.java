package models;

import interfaces.ICard;
import interfaces.IList;
import interfaces.IUser;
import services.ListKGS;

import java.util.HashMap;
import java.util.List;

public class ListT implements IList{
	public String Id;
	public String Name;
	public HashMap<String,ICard> Cards;
	String boardId;
	
	public ListT(String name, HashMap<String,ICard> cards, String boardId){
		this.Cards = cards;
		this.Name = name;
		this.Id = ListKGS.getKey();
		this.boardId = boardId;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public HashMap<String,ICard> getCards() {
		return Cards;
	}
	public void setCard(HashMap<String,ICard> cards) {
		Cards = cards;
	}
	
	public String getBoardId() {
		return this.boardId;
	}
}
