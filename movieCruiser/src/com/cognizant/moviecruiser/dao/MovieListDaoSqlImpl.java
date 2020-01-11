package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoSqlImpl implements MoviesDao {

	public static final String GET_MOVIELIST_ADMIN = "select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie";
	public static final String GET_MOVIELIST_CUSTOMER = "select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie where mo_active = 1 and mo_date_of_launch > (SELECT CURRENT_DATE())";
	public static final String GET_MOVIELIST = "select mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie where mo_id = ?";
	public static final String EDIT_MOVIELIST = "update movie set mo_title = ?, mo_box_office = ?, mo_active = ?, mo_date_of_launch = ?, mo_genre = ?, mo_has_teaser = ? where mo_id = ?";

	@Override
	public List<Movies> getMovieListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> movieListAdmin = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(GET_MOVIELIST_ADMIN);
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
				movieListAdmin.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieListAdmin;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> movieListCustomer = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(GET_MOVIELIST_CUSTOMER);
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
				movieListCustomer.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieListCustomer;
	}

	@Override
	public void modifyMovieList(Movies movieList) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(EDIT_MOVIELIST);

			preparedStatement.setString(1, movieList.getTitle());
			preparedStatement.setFloat(2, movieList.getGross());
			preparedStatement.setString(3, movieList.isActive() ? "1" : "0");
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(movieList.getDateOfLaunch()));
			preparedStatement.setString(5, movieList.getGenre());
			preparedStatement.setString(6, movieList.isTeaser() ? "1" : "0");
			preparedStatement.setLong(7, movieList.getId());
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
	public Movies getMovieList(Long movieListId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movies = null;

		try {
			preparedStatement = connection.prepareStatement(GET_MOVIELIST);
			preparedStatement.setLong(1, movieListId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getInt("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movies;
	}

}
