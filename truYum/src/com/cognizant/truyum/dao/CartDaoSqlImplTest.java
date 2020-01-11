package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {
	
	public static void testaddCartItem() {
		long userId = 2;
		long menuItemId = 1;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(userId, menuItemId);
		
		System.out.println("------------------------------------------------------------");
	}
	
	public static void testgetAllCartItems() throws CartEmptyException {
		long userId = 1;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart x = cartDaoSqlImpl.getAllCartItems(userId);
		System.out.println(x.getMenuItemList());
		System.out.println("--------------------------------------");
		System.out.println(x.getTotal());
		System.out.println("--------------------------------------");
	}
	
	public static void testremoveCartItem() {
		long userId = 2;
		long menuItemId = 1;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(userId, menuItemId);
	}

	public static void main(String[] args) throws CartEmptyException {
		testaddCartItem();
		testgetAllCartItems();
		testremoveCartItem();
		//testgetAllCartItems();
	}

}
