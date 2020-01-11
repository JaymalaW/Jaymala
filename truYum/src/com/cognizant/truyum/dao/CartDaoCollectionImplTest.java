package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		// 1.Instantiate CartDaoCollectionImpl and assign it to CartDao reference
		// variable cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2.Invoke cartDao.addCartItem()
		cartDao.addCartItem(1, 2);
		cartDao.addCartItem(1, 5);
		cartDao.addCartItem(1, 3);
		cartDao.addCartItem(2, 1);
		cartDao.addCartItem(2, 3);

		Cart cart = cartDao.getAllCartItems(1);
		System.out.println("User Added Cart List for CheckOut");
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}

		Cart cart1 = cartDao.getAllCartItems(2);
		System.out.println("User Added Cart List for CheckOut");
		for (MenuItem menuItem : cart1.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it CartDao reference variable
		// cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke CartDao.removeCartItem()
		try {
			cartDao.removeCartItem(1, 2);
			// cartDao.removeCartItem(1, 3);
			cartDao.removeCartItem(2, 1);
			// cartDao.removeCartItem(1, 5);
			// cartDao.removeCartItem(2, 3);
			// 3. Invoke cartDao.getAllCartItems() with userId as 1 and 2
			Cart cart = cartDao.getAllCartItems(1);
			System.out.println("Item List for Customer for remove");
			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}

			Cart cart1 = cartDao.getAllCartItems(2);
			System.out.println("Item List for Customer for remove");
			for (MenuItem menuItem : cart1.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
	}
}
