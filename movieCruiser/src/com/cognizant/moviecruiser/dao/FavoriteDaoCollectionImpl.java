package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoriteDaoCollectionImpl implements FavoritesDao {
	private static HashMap<Long, Favorites> userFavorite;

	public FavoriteDaoCollectionImpl() {
		super();
		if (userFavorite == null) {
			userFavorite = new HashMap<>();
		}
	}

	@Override
	public void addFavoriteMovie(long userId, long movieId) {
		MoviesDao movieDao = new MovieListDaoCollectionImpl();
		Movies movieList = movieDao.getMovieList(movieId);
		if (userFavorite.containsKey(userId)) {
			userFavorite.get(userId).getMovieList().add(movieList);
		} else {
			Favorites favorites = new Favorites();
			ArrayList<Movies> movieListItem = new ArrayList<>();
			movieListItem.add(movieList);
			favorites.setMovieList(movieListItem);
			userFavorite.put(userId, favorites);
		}
	}

	@Override
	public Favorites getAllFavoriteMovie(long userId) throws FavoriteEmptyException {
		//List<Movies> movieListItem = userFavorite.get(userId).getMovieList();
		Favorites favorites = userFavorite.get(userId);
		//List<Movies> movieListItem = favorites.getMovieList();
		if (favorites == null || favorites.getMovieList().isEmpty()) {
			throw new FavoriteEmptyException();
		}
		return favorites;
	}

	@Override
	public void removeFavoriteMovie(long userId, long movieId) {
		List<Movies> movieListItem = userFavorite.get(userId).getMovieList();
		for (int i = 0; i < movieListItem.size(); i++) {
			if (movieListItem.get(i).getId() == movieId) {
				movieListItem.remove(i);
				return ;
			}
			
		}
	}
}
