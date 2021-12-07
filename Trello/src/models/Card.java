package models;

import interfaces.ICard;
import interfaces.IUser;
import services.CardKGS;

public class Card implements ICard{
	public String Id;
	public String Name;
	public String Description;
	public IUser AssingedUser = null;
	public String ListId;
	
	public Card(String name, String description, IUser assignedUser, String listId){
		this.AssingedUser = assignedUser;
		this.Id = CardKGS.getKey();
		this.Name = name;
		this.Description = description;
		this.ListId = listId;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public IUser getAssingedUser() {
		return AssingedUser;
	}
	public void setAssingedUser(IUser assingedUser) {
		AssingedUser = assingedUser;
	}
	
	public String getListId() {
		return this.ListId;
	}
}
