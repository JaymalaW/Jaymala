package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoriteDaoCollectionImplTest {

	public static void testAddFavoriteMovie() throws FavoriteEmptyException {
		FavoritesDao favoriteDao = new FavoriteDaoCollectionImpl();
		favoriteDao.addFavoriteMovie(1, 2);
		favoriteDao.addFavoriteMovie(1, 1);
		favoriteDao.addFavoriteMovie(1, 5);
		favoriteDao.addFavoriteMovie(2, 3);
		favoriteDao.addFavoriteMovie(2, 4);
		favoriteDao.addFavoriteMovie(2, 5);

		Favorites favorites = favoriteDao.getAllFavoriteMovie(1);
		List<Movies> movieListItem = favorites.getMovieList();
		System.out.println("User Added Favorite list for Checkout");
		for (Movies movies : movieListItem) {
			System.out.println(movies);
		}
		System.out.println("Favorites are : " + movieListItem.size());

		Favorites favorites1 = favoriteDao.getAllFavoriteMovie(1);
		List<Movies> movieListItem1 = favorites1.getMovieList();
		System.out.println("User Added Favorite list for Checkout");
		for (Movies movies : movieListItem1) {
			System.out.println(movies);
		}
		System.out.println("Favorites are : " + movieListItem1.size());

	}

	public static void testRemoveFavoriteMovie() throws FavoriteEmptyException {
		FavoritesDao favoritesDao = new FavoriteDaoCollectionImpl();
		try {
			favoritesDao.removeFavoriteMovie(1, 2);
			// favoritesDao.removeFavoriteItem(1, 5);
			favoritesDao.removeFavoriteMovie(1, 1);
			// favoritesDao.removeFavoriteItem(2, 3);
			// favoritesDao.removeFavoriteItem(2, 4);
			favoritesDao.removeFavoriteMovie(2, 5);
			
			Favorites favorites = favoritesDao.getAllFavoriteMovie(1);
			List<Movies> movieListItem = favorites.getMovieList();
			System.out.println("Item List for Customer to remove");
			for (Movies movies : movieListItem) {
				System.out.println(movies);
			}
			System.out.println("Favorites are : " + movieListItem.size());

			Favorites favorites1 = favoritesDao.getAllFavoriteMovie(1);
			List<Movies> movieListItem1 = favorites1.getMovieList();
			System.out.println("Item List for Customer to remove");
			for (Movies movies : movieListItem1) {
				System.out.println(movies);
			}
			System.out.println("Favorites are : " + movieListItem1.size());
		} catch (FavoriteEmptyException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws FavoriteEmptyException {
		testAddFavoriteMovie();
		testRemoveFavoriteMovie();
	}
}
