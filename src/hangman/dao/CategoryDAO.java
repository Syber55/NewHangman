package hangman.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import hangman.model.Category;

public interface CategoryDAO {

	public void insertCategory(String categoryName) throws SQLException ;
	public ArrayList<Category> getCategoryArray() throws SQLException ;
}
