package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecruiser.dao.MoviesDao;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		long gross = Long.parseLong(request.getParameter("gross"));
		boolean active = request.getParameter("active").equals("yes");
		Date dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String genre = request.getParameter("genre");
		boolean teaser = request.getParameter("teaser") != null;
		Movies movieList = new Movies(id, title, gross, active, dateOfLaunch, genre, teaser);
		MoviesDao moviesDao = new MovieListDaoSqlImpl();
		moviesDao.modifyMovieList(movieList);
		RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
		rd.forward(request, response);
		doGet(request, response);
	}

}
