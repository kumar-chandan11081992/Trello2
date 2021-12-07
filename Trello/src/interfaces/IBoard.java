package interfaces;

import java.util.HashMap;
import java.util.List;

import enumerations.Privacy;

public interface IBoard {
	public String getBoardId();
	public String getBoardName();
	public Privacy getPrivacy();
	public String getUrl();
	public HashMap<String,IUser> getMembers();
	public HashMap<String, IList> getLists();
	String ToString();
}
