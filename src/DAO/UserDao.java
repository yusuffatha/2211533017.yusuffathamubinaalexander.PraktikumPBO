package DAO;

public interface UserDao {
	void save (User user);
	public List<User> show();
	public void delete(String id);
	public void update(User user);

}
