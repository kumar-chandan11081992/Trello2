package interfaces;

import java.util.HashMap;
import java.util.List;

public interface IListService {
	
	public IList getList(String listId);
	public IList createList(String name, HashMap<String,ICard> cards, String boardId);
	public IList modifyList(String listId, IList list);
	public void deleteList(String listId);
}
