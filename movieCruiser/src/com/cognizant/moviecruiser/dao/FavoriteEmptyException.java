package com.cognizant.moviecruiser.dao;

public class FavoriteEmptyException extends Exception {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FavoriteEmptyException() {
		super("Favorites list is empty");
	}
}
