package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {
	private List<Movies> movieListItem;
	private int noOfFavorites;

	public Favorites() {
		super();
	}

	public Favorites(List<Movies> movieList, int noOfFavorites) {
		super();
		this.movieListItem = movieList;
		this.noOfFavorites = noOfFavorites;
	}

	public List<Movies> getMovieList() {
		return movieListItem;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieListItem = movieList;
	}

	public int getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(int noOfFavorites2) {
		this.noOfFavorites = noOfFavorites2;
	}
}
