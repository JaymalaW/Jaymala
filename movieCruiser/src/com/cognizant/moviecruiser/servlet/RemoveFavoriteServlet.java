package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;
import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet("/RemoveFavorite")
public class RemoveFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFavoriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long userId = 1l;
		long movieId = Long.parseLong(request.getParameter("id"));
		FavoritesDao favoritesDao = new FavoriteDaoSqlImpl();
		favoritesDao.removeFavoriteMovie(userId, movieId);
		try {
			request.setAttribute("favorites", favoritesDao.getAllFavoriteMovie(userId));
			Favorites favorites = favoritesDao.getAllFavoriteMovie(userId);
			List<Movies> movieListItem = favorites.getMovieList();
			request.setAttribute("favoritesCount", movieListItem.size());
			request.setAttribute("message", true);
			request.getRequestDispatcher("favorites.jsp").forward(request, response);
		} catch (FavoriteEmptyException e) {
			request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
