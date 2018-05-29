package hangman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hangman.model.User;

public class UserDAOImpl implements UserDAO {

	static Connection conn;
	static PreparedStatement ps;

	@Override
	public int insertUser(User user) {
		int status = 0;
		try {

			conn = ConnectionManager.getInstance().getConnection();
			ps = conn.prepareStatement("INSERT INTO users VALUES (null,?,?) ");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			status = ps.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public User getUser(String username, String password) {

		User user = new User();

		try {

			conn = ConnectionManager.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserID(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return user;
	}

}
