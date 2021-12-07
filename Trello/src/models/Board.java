package models;

import java.util.HashMap;
import java.util.List;

import interfaces.IBoard;
import interfaces.IList;
import interfaces.IUser;
import services.BoardKGS;
import services.UrlService;
import enumerations.*;

public class Board implements IBoard{

	public String Id;
	public String Name;
	public Privacy privacy = Privacy.PUBLIC;
	public String Url;
	public HashMap<String,IUser> Members;
	public HashMap<String,IList> Lists;
	
	public Board(String Name,Privacy privacy, HashMap<String,IUser> Members,HashMap<String,IList> Lists){
		this.Id = BoardKGS.getKey();
		this.privacy = privacy;
		this.Url = UrlService.getUrl(this.Id);
		this.Members = Members;
		this.Lists = Lists;
	}
	
	public Board(Privacy privacy, HashMap<String,IUser> Members,HashMap<String,IList> Lists){
		this.privacy = privacy;
		this.Members = Members;
		this.Lists = Lists;
	}
	
	public Board(HashMap<String,IUser> Members){
		this.Members = Members;
	}
	@Override
	public String getBoardId() {
		return this.Id;
	}

	@Override
	public String getBoardName() {
		return this.Name;
	}

	@Override
	public Privacy getPrivacy() {
		return this.privacy;
	}

	@Override
	public String getUrl() {
		return this.Url;
	}

	@Override
	public HashMap<String,IUser> getMembers() {
		return this.Members;
	}

	@Override
	public HashMap<String,IList> getLists() {
		return this.Lists;
	}


	public void setId(String id) {
		Id = id;
	}


	public void setName(String name) {
		Name = name;
	}

	public void setPrivacy(String privacy) {
		privacy = privacy;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public void setMembers(HashMap<String,IUser> members) {
		Members = members;
	}

	public void setLists(HashMap<String,IList> lists) {
		Lists = lists;
	}
	
	@Override
	public
	String ToString(){
	    return "Id :: '" + this.Id + "' Name: '" + this.Name + "', privacy: '" + this.privacy + "', Url: '" + this.Url + "'";
	}

}
