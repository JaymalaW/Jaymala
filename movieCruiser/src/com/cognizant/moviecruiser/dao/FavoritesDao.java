package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {

	public void addFavoriteMovie(long userId, long movieId);

	public Favorites getAllFavoriteMovie(long userId) throws FavoriteEmptyException;

	public void removeFavoriteMovie(long userId, long movieId);
}
