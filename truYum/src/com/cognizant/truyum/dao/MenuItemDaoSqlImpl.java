package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao{
	
	public static final String GETALL_MENUITEM_ADMIN = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item";
	public static final String GETALL_MENUITEM_CUSTOMER = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item where me_active = '1' and me_date_of_launch > (SELECT CURRENT_DATE())";
	public static final String GET_MENUITEM = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item where me_id = ?";
	public static final String EDIT_MENUITEM = "update menu_item set me_name = ?, me_price = ?, me_active = ?, me_date_of_launch = ?, me_category = ?, me_free_delivery = ? where me_id = ?";
//	public static ArrayList<MenuItem> menuItemListAdmin = new ArrayList<>();
	
	public List<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemListAdmin = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement(GETALL_MENUITEM_ADMIN);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getInt("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItemListAdmin.add(menuItem);				
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return menuItemListAdmin;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemListCustomer = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement(GETALL_MENUITEM_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getInt("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItemListCustomer.add(menuItem);				
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return menuItemListCustomer;
//		return null;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		System.out.println(menuItem);
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = connection.prepareStatement(EDIT_MENUITEM);			
			
			preparedStatement.setString(1, menuItem.getName());
			preparedStatement.setFloat(2, menuItem.getPrice());
			preparedStatement.setString(3, menuItem.isActive()?"1":"0");
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			preparedStatement.setString(5, menuItem.getCategory());
			preparedStatement.setBoolean(6, menuItem.isFreeDelivery());
			preparedStatement.setLong(7, menuItem.getId());
			preparedStatement.executeUpdate();			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}	
	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MenuItem menuItem = null;
		
		try {
			preparedStatement = connection.prepareStatement(GET_MENUITEM);
			preparedStatement.setLong(1, menuItemId);
			resultSet = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getInt("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return menuItem;
	}
}
