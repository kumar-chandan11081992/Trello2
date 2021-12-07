package interfaces;

public interface IUserService {
	public IUser getUser(String userId);
	public IUser createUser(String Id, String Name, String Email);
	public IUser modifyUser(String userId, IUser user);
	public void deleteUser(String userId);
}
