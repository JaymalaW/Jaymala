package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao{
	
	public static final String ADD_MENUITEM_TO_CART = "insert into cart (ct_us_id, ct_me_id) values (?,?)";
	public static final String GET_MENUITEM_FROM_CART = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item inner join truyum.cart as Result on ct_me_id = me_id where ct_us_id = ?";
	public static final String GET_TOTALPRICE_FROM_CART = "select SUM(me_price) as Total_Price from menu_item inner join truyum.cart as Total on ct_me_id = me_id where ct_us_id = ?";
	public static final String REMOVE_MENUITEM_FROM_CART = "delete from cart where ct_us_id = ? and ct_me_id = ? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(ADD_MENUITEM_TO_CART);	
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
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
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		Cart cart = new Cart();
		cart.setTotal(0.00);
		ArrayList<MenuItem> menuItemListCart = new ArrayList<>();
		PreparedStatement preparedStatementList = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		
		try {
			preparedStatement = connection.prepareStatement(GET_MENUITEM_FROM_CART);
			preparedStatement.setLong(1, userId);
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
				menuItemListCart.add(menuItem);
			}
			cart.setMenuItemList(menuItemListCart);
						
			preparedStatementList = connection.prepareStatement(GET_TOTALPRICE_FROM_CART);
			preparedStatementList.setLong(1, userId);
			resultSetTotal = preparedStatementList.executeQuery();
			
			if(menuItemListCart.size()==0)
				throw new CartEmptyException();
			
			while(resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total_Price"));
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
				if(resultSetTotal!=null)
					resultSetTotal.close();
				if(preparedStatementList!=null)
					preparedStatementList.close();	
				if(connection!=null)
					connection.close();
											
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(REMOVE_MENUITEM_FROM_CART);	
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
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
	
}
