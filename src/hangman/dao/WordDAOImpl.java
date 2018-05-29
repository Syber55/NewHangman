package hangman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import hangman.model.Rijeci;

public class WordDAOImpl implements WordDAO {

	Connection connection = DBConnection.getConnectionToDatabase();

	@Override
	public ArrayList<Rijeci> getWords() throws SQLException {

		ArrayList<Rijeci> words = new ArrayList<>();

		String query = "SELECT * FROM words";

		ResultSet rs = null;

		try (Statement statement = connection.createStatement();) {

			rs = statement.executeQuery(query);

			while (rs.next()) {
				Rijeci word = new Rijeci(rs.getString("Word"), rs.getInt("CategoryID"));
				words.add(word);
			}
		}

		return words;
	}

	@Override
	public ArrayList<Rijeci> getWords(int categoryID) throws SQLException {

		ArrayList<Rijeci> words = new ArrayList<>();

		String query = "SELECT * FROM words WHERE CategoryID = " + categoryID;

		ResultSet rs = null;

		try (Statement statement = connection.createStatement();) {

			rs = statement.executeQuery(query);

			while (rs.next()) {
				Rijeci word = new Rijeci(rs.getString("Word"), rs.getInt("CategoryID"));
				words.add(word);
			}
		}

		return words;
	}

	@Override
	public void addWord(String word, int categoryID) throws SQLException {
		
		String query = "INSERT INTO words(Word, CategoryID) VALUES (?, ?)";

		try (
				PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, word);
			statement.setInt(2, categoryID);

			statement.executeUpdate();
		}

	}

	@Override
	public Rijeci getRandomWord() throws SQLException {
		
		ArrayList<Rijeci> words = getWords();
	
		Random rand = new Random();
		
		int random = rand.nextInt(words.size() - 1);
		
		return words.get(random);
	}

}