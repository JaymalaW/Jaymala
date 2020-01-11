package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoCollectionImpl implements MoviesDao {
	private static List<Movies> movieListItem;

	public MovieListDaoCollectionImpl() {
		super();
		// TODO Auto-generated constructor stub
		if (movieListItem == null) {
			movieListItem = new ArrayList<Movies>();
			Movies itemOne = new Movies(1, "Avtar", 2787965087L, true, new DateUtil().convertToDate("15/03/2017"),
					"Science Fiction", true);
			Movies itemTwo = new Movies(2, "The Avengers", 1518812988L, true,
					new DateUtil().convertToDate("23/12/2017"), "Superhero", false);
			Movies itemThree = new Movies(3, "Titanic", 2187463944L, true, new DateUtil().convertToDate("21/08/2017"),
					"Romance", false);
			Movies itemFour = new Movies(4, "Jurassic World", 1671713208L, false,
					new DateUtil().convertToDate("02/07/2017"), "Science Fiction", true);
			Movies itemFive = new Movies(5, "Avengers:End Game", 2750760348L, true,
					new DateUtil().convertToDate("02/11/2022"), "Superhero", true);
			movieListItem.add(itemOne);
			movieListItem.add(itemTwo);
			movieListItem.add(itemThree);
			movieListItem.add(itemFour);
			movieListItem.add(itemFive);
		}
	}

	@Override
	public List<Movies> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieListItem;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		ArrayList<Movies> filteredMovieList = new ArrayList<Movies>();
		for (Movies movieList : movieListItem) {
			if (movieList.getDateOfLaunch().after(new Date())) {
				if (movieList.isActive()) {
					filteredMovieList.add(movieList);
				}
			}
		}
		return filteredMovieList;
	}

	@Override
	public void modifyMovieList(Movies movieList) {
		for (int i = 0; i < movieListItem.size(); i++) {
			if (movieListItem.get(i).getId() == movieList.getId()) {
				movieListItem.set(i, movieList);
			}
		}
	}

	@Override
	public Movies getMovieList(Long movieListId) {
		for (Movies movieList : movieListItem) {
			if (movieList.getId() == movieListId) {
				return movieList;
			}
		}
		return null;
	}
}
