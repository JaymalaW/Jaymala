package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		List<MenuItem> menuItemListAdmin = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("######.00");
		
		System.out.format("\n%-10s%-25s%-15s%-10s%-25s%-25s%-10s\n","ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH", "CATEGORY", "FREE DELIVERY");
		for(MenuItem menuItem : menuItemListAdmin) {
			String date = format.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			String price = df.format(menuItem.getPrice());
			System.out.format("\n%-10d%-25s%-15s%-10s%-25s%-25s%-10s\n", menuItem.getId(), menuItem.getName(), price, menuItem.isActive(), date, menuItem.getCategory(), menuItem.isFreeDelivery());
		}	
		System.out.println("------------------------------------------------------------");
	}
	
	public static void testGetMenuItemListCustomer() {
		List<MenuItem> menuItemListCustomer = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("######.00");
		
		System.out.format("\n%-10s%-25s%-15s%-10s%-25s%-25s%-10s\n","ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH", "CATEGORY", "FREE DELIVERY");
		for(MenuItem menuItem : menuItemListCustomer) {
			String date = format.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			String price = df.format(menuItem.getPrice());
			System.out.format("\n%-10d%-25s%-15s%-10s%-25s%-25s%-10s\n", menuItem.getId(), menuItem.getName(), price, menuItem.isActive(), date, menuItem.getCategory(), menuItem.isFreeDelivery());
		}	
		System.out.println("------------------------------------------------------------");
	}
	
	public static void testModifyMenuItem() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("######.00");
		
		MenuItem menuItem = new MenuItem(1, "Sandwich Toast", 33.33f, true, new DateUtil().convertToDate("15/01/2020"), "Dessert", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
		System.out.format("\n%-10s%-25s%-15s%-10s%-25s%-25s%-10s\n","ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH", "CATEGORY", "FREE DELIVERY");
		String date = format.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
		String price = df.format(menuItem.getPrice());
		System.out.format("\n%-10d%-25s%-15s%-10s%-25s%-25s%-10s\n", menuItem.getId(), menuItem.getName(), price, menuItem.isActive(), date, menuItem.getCategory(), menuItem.isFreeDelivery());
		System.out.println("------------------------------------------------------------");
	}
	
	public static void testGetMenuItem() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("######.00");
		
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		long menuItemId = 3;
		MenuItem menuItem = menuItemDaoSqlImpl.getMenuItem(menuItemId);
		System.out.format("\n%-10s%-25s%-15s%-10s%-25s%-25s%-10s\n","ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH", "CATEGORY", "FREE DELIVERY");
		String date = format.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
		String price = df.format(menuItem.getPrice());
		System.out.format("\n%-10d%-25s%-15s%-10s%-25s%-25s%-10s\n", menuItem.getId(), menuItem.getName(), price, menuItem.isActive(), date, menuItem.getCategory(), menuItem.isFreeDelivery());
		System.out.println("------------------------------------------------------------");
	}
	
	public static void main(String[] args) {
		
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
//		Connection connection = ConnectionHandler.getConnection();
//		System.out.println(connection);
	}

}
