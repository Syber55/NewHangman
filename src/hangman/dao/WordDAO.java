package hangman.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import hangman.model.Rijeci;

public interface WordDAO {

	public ArrayList<Rijeci> getWords() throws SQLException;
	
	public ArrayList<Rijeci> getWords(int categoryID) throws SQLException;

	public void addWord(String word, int categoryID) throws SQLException;
	
	public Rijeci getRandomWord() throws SQLException;
	
	public Rijeci getRandomCategoryWord(int categoryID) throws SQLException;
	
}