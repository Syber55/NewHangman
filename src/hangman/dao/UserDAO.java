package hangman.dao;

import hangman.model.User;

public interface UserDAO {
	
	public int insertUser(User user);
	public User getUser(String username, String password);

}
