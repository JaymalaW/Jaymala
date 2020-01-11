package com.cognizant.moviecruiser.dao;

import java.util.List;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoCollectionImplTest {

	public static void testGetMovieListAdmin() {
		System.out.println("Movie list for Admin");
		List<Movies> movieListAdmin = new MovieListDaoCollectionImpl().getMovieListAdmin();
		for (Movies movieList : movieListAdmin) {
			System.out.println(movieList);
		}
	}

	public static void testGetMovieListCustomer() {
		System.out.println("Movie List Customer");
		List<Movies> movieListCustomer = new MovieListDaoCollectionImpl().getMovieListCustomer();
		for (Movies movieList : movieListCustomer) {
			System.out.println(movieList);
		}
	}

	public static void testModifyMovieList() {
		Movies itemSix = new Movies(3, "Harry Potter", 2987787075L, true, new DateUtil().convertToDate("13/12/2019"),
				"SuperHero", true);
		MoviesDao movieDao = new MovieListDaoCollectionImpl();
		movieDao.modifyMovieList(itemSix);
		System.out.println("*************Modified List***************");
		testGetMovieListAdmin();
		Movies modifiedList = movieDao.getMovieList(itemSix.getId());
		System.out.println("\nModified Item Detail : " + modifiedList);
	}

	public static void main(String[] args) {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovieList();
	}
}
