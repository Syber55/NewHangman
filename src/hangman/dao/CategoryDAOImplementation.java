package hangman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import hangman.model.Category;
public class CategoryDAOImplementation implements CategoryDAO{

	Connection connection = DBConnection.getConnectionToDatabase();
	
	@Override
	public void insertCategory(String categoryName) throws SQLException {
		
		String query = "INSERT INTO wordcategory(Word) VALUES (?)";

		try (
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, categoryName);

			statement.executeUpdate();
		}
		
	}

	@Override
	public ArrayList<Category> getCategoryArray() throws SQLException {
		
		ArrayList<Category> categories = new ArrayList<>();
		
		String query = "SELECT * FROM wordcategory";

		ResultSet rs = null;

		try (Statement statement = connection.createStatement();) {

			rs = statement.executeQuery(query);

			while (rs.next()) {
				Category category = new Category(rs.getInt("CategoryID"), rs.getString("Word"));
				categories.add(category);
			}
		}
		return categories;
	}

	
}
