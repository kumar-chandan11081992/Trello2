package interfaces;

import java.util.HashMap;
import java.util.List;

import enumerations.Privacy;

public interface IBoardService {
	
	public IBoard getBoard(String boardId);
	public List<IBoard> getBoards(String boardId);
	public IBoard createBoard(String name, Privacy privacy,String url,HashMap<String,IUser> members,HashMap<String, IList> lists);
	public IBoard addMembersToBoard(IUser member, IBoard board);
	public IBoard removeMembersFromBoard(IUser member, IBoard board);
	public IBoard updateMembersInBoard(IUser member, IBoard board);
	public void deleteBoard(String boardId);
	public IBoard moveCards(String listFrom, String listTo, String cardId);
}
