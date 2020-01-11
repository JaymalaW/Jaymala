package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Menu item List Admin");
		// MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemListAdmin = new MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemListAdmin) {
			System.out.println(menuItem);
			// System.out.println(new
			// DateUtil().convertToString(menuItem.getDateOfLaunch()));
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Menu item List Customer");
		// MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer = new MenuItemDaoCollectionImpl().getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		// 1. Create an instance for Menu Item with id matching with one of the menu
		// item already added to the menuItemList
		MenuItem itemFive = new MenuItem(5, "Chocolate Brownie", 80.00f, true,
				new DateUtil().convertToDate("13/12/2020"), "Desserts", true);
		// 2. Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 3. Invoke MenuItemDao.modifyMenuItem(menuItem) by passing the menu item
		// created in the first step.
		menuItemDao.modifyMenuItem(itemFive);
		System.out.println("**Modified List**");
		testGetMenuItemListAdmin();
		MenuItem modified_Item = menuItemDao.getMenuItem(itemFive.getId());
		System.out.println("\nModified Item Detail = " + modified_Item);
	}

	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}
}
