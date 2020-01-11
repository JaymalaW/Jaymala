package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoSqlImplTest {

	public static void testgetMovieListAdmin() {
		List<Movies> movieListAdmin = new MovieListDaoSqlImpl().getMovieListAdmin();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");

		System.out.println("--------------------------Admin----------------------------------");
		System.out.format("\n%-10s%-25s%-25s%-10s%-25s%-25s%-10s\n", "ID", "TITLE", "BOX OFFICE", "ACTIVE",
				"DATE OF LAUNCH", "GENRE", "HAS TEASER");
		for (Movies movies : movieListAdmin) {
			String date = format.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			String gross = df.format(movies.getGross());
			System.out.format("\n%-10d%-25s%-25s%-10s%-25s%-25s%-10s\n", movies.getId(), movies.getTitle(), gross,
					movies.isActive(), date, movies.getGenre(), movies.isTeaser());
		}
		System.out.println("------------------------------------------------------------------");
	}

	public static void testgetMovieListCustomer() {
		List<Movies> movieListCustomer = new MovieListDaoSqlImpl().getMovieListCustomer();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");

		System.out.println("----------------------------Customer--------------------------------");
		System.out.format("\n%-10s%-25s%-25s%-10s%-25s%-25s%-10s\n", "ID", "TITLE", "BOX OFFICE", "ACTIVE",
				"DATE OF LAUNCH", "GENRE", "HAS TEASER");
		for (Movies movies : movieListCustomer) {
			String date = format.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			String gross = df.format(movies.getGross());
			System.out.format("\n%-10d%-25s%-25s%-10s%-25s%-25s%-10s\n", movies.getId(), movies.getTitle(), gross,
					movies.isActive(), date, movies.getGenre(), movies.isTeaser());
		}
		System.out.println("------------------------------------------------------------------");
	}

	public static void testmodifyMovieList() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");

		Movies movie = new Movies(1, "Avtar-Alien ", 3787965087L, false, new DateUtil().convertToDate("15/12/2017"),
				"Science Fiction", false);
		MovieListDaoSqlImpl movieListDaoSqlImpl = new MovieListDaoSqlImpl();
		movieListDaoSqlImpl.modifyMovieList(movie);

		System.out.println("----------------------------Modify--------------------------------");
		System.out.format("\n%-10s%-25s%-25s%-10s%-25s%-25s%-10s\n", "ID", "TITLE", "BOX OFFICE", "ACTIVE",
				"DATE OF LAUNCH", "GENRE", "HAS TEASER");
		String date = format.format(DateUtil.convertToSqlDate(movie.getDateOfLaunch()));
		String gross = df.format(movie.getGross());
		System.out.format("\n%-10d%-25s%-25s%-10s%-25s%-25s%-10s\n", movie.getId(), movie.getTitle(), gross,
				movie.isActive(), date, movie.getGenre(), movie.isTeaser());
		System.out.println("------------------------------------------------------------------");
	}

	public static void testgetMovieList() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		MovieListDaoSqlImpl movieListDaoSqlImpl = new MovieListDaoSqlImpl();
		long movieListId = 4;
		Movies movie = movieListDaoSqlImpl.getMovieList(movieListId);
		System.out.println("----------------------------Movie--------------------------------");
		System.out.format("\n%-10s%-25s%-25s%-10s%-25s%-25s%-10s\n", "ID", "TITLE", "BOX OFFICE", "ACTIVE",
				"DATE OF LAUNCH", "GENRE", "HAS TEASER");
		String date = format.format(DateUtil.convertToSqlDate(movie.getDateOfLaunch()));
		String gross = df.format(movie.getGross());
		System.out.format("\n%-10d%-25s%-25s%-10s%-25s%-25s%-10s\n", movie.getId(), movie.getTitle(), gross,
				movie.isActive(), date, movie.getGenre(), movie.isTeaser());
		System.out.println("------------------------------------------------------------------");
	}

	public static void main(String[] args) {
		testgetMovieListAdmin();
		testgetMovieListCustomer();
		testmodifyMovieList();
		testgetMovieList();
	}

}
