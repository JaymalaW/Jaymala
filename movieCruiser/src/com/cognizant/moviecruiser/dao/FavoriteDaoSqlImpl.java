package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoriteDaoSqlImpl implements FavoritesDao {

	public static final String ADD_MOVIE_TO_CART = "insert into favorite (fv_us_id, fv_mo_id) values(?,?)";
	public static final String GET_MOVIE_FROM_CART = "select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie inner join moviecruiser.favorite as Result on fv_mo_id = mo_id where fv_us_id = ?";
	public static final String GET_NO_OF_FAVORITE_FROM_CART = "select count(fv_id) as No_of_Favorite from favorite where fv_us_id = ?";
	public static final String REMOVE_MOVIE_FROM_CART = "delete from favorite where fv_us_id = ? and fv_mo_id = ? limit 1";

	@Override
	public void addFavoriteMovie(long userId, long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIE_TO_CART);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, movieId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Favorites getAllFavoriteMovie(long userId) throws FavoriteEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		Favorites favorites = new Favorites();
		favorites.setNoOfFavorites(0);
		List<Movies> movieListFavorite = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementList = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;

		try {
			preparedStatement = connection.prepareStatement(GET_MOVIE_FROM_CART);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getInt("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieListFavorite.add(movies);
			}
			favorites.setMovieList(movieListFavorite);

			preparedStatementList = connection.prepareStatement(GET_NO_OF_FAVORITE_FROM_CART);
			preparedStatementList.setLong(1, userId);
			resultSetTotal = preparedStatementList.executeQuery();

			if (movieListFavorite.size() == 0)
				throw new FavoriteEmptyException();
			while (resultSetTotal.next()) {
				favorites.setNoOfFavorites(resultSetTotal.getInt("No_of_Favorite"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (preparedStatementList != null)
					preparedStatementList.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favorites;
	}

	@Override
	public void removeFavoriteMovie(long userId, long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(REMOVE_MOVIE_FROM_CART);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, movieId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
