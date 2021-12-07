package interfaces;

import java.util.HashMap;
import java.util.List;

public interface IList {
	public String getId();
	public String getName();
	public HashMap<String,ICard> getCards();
	public String getBoardId();
}
