package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoriteDaoSqlImplTest {

	public static void testaddFavoriteMovie() {
		long userId = 1;
		long movieId = 3;
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		favoriteDaoSqlImpl.addFavoriteMovie(userId, movieId);

		System.out.println("----------------------------Added to Fav----------------------------");
	}

	public static void testgetAllFavoriteMovie() throws FavoriteEmptyException {
		long userId = 1;
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		Favorites fav = favoriteDaoSqlImpl.getAllFavoriteMovie(userId);
		System.out.println(fav.getMovieList());
		System.out.println("--------------------------------------");
		System.out.println(fav.getNoOfFavorites());
		System.out.println("--------------------------------------");
	}

	public static void testremoveFavoriteMovie() {
		long userId = 1;
		long movieId = 1;
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		favoriteDaoSqlImpl.removeFavoriteMovie(userId, movieId);
	}

	public static void main(String[] args) throws FavoriteEmptyException {
		testaddFavoriteMovie();
		testgetAllFavoriteMovie();
		testremoveFavoriteMovie();
	}

}
