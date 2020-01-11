package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	
	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// 1.Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 2.Get the menuItem using menuItemDao.getMenuItem(menuItemId) method
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		// 3.Check existence of user in userCarts based on userId
		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(menuItem);
		} else {
			// Create a new cart instance with new ArrayList.
			Cart cart = new Cart();
			ArrayList<MenuItem> menuItemList = new ArrayList<>();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			// Put the userId and ArrayList of MenuItem into the userCarts.
			userCarts.put(userId, cart);
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
//		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		Cart cart = userCarts.get(userId);
		double total = 0.0;
		if (cart == null || cart.getMenuItemList().isEmpty()) {
			throw new CartEmptyException();
		}
		List<MenuItem> menuItemList = cart.getMenuItemList();
			for (MenuItem menuItem : menuItemList) {
				total += menuItem.getPrice();
			}
		
		cart.setTotal(total);
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// 1. Get the List<MenuItem> from userCarts based on userId
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		// 2. Iterate through the List of MenuItem
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				// b. If menuItemId matches then remove the menu item form the list
				menuItemList.remove(i);
				return;
			}
		}
	}
}
