package hangman.dao;

import java.util.ArrayList;
import hangman.model.Category;

public interface CategoryDAO {

	public void insertCategory(String categoryName);
	public ArrayList<Category> getCategoryArray();
}
