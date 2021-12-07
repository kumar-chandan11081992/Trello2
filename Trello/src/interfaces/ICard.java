package interfaces;

public interface ICard {
	public String getId();
	public String getName();
	public String getDescription();
	public IUser getAssingedUser();
	public void setAssingedUser(IUser user);
	public String getListId();
}
