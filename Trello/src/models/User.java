package models;

import interfaces.IUser;

public class User implements IUser{
	public String Id;
	public String Name;
	public String Email;
	
	public User(String Id, String Name, String Email){
		this.Id = Id;
		this.Name = Name;
		this.Email = Email;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
