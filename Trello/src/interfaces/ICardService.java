package interfaces;

import java.util.List;

public interface ICardService {
	
	public ICard getCard(String cardId);
	public ICard createCard(String name,String description, IUser assignedUser, String listId);
	public ICard assignMember(ICard card, IUser member);
	public ICard modifyCard(String cardId, ICard card);
	public void deleteCard(String cardId);
}
