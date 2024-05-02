package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {



	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/product";
		String userName = "root";
		String password = "ajith123";
		String query = "select * from product";
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();

		System.out.println(connection);

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "ajith123");
		return connection;

	}

	public static void insert(int items, String username, int password, int productId, String productName, int qty,
			int price, int totalPrice) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "insert into product values(?,?,?,?,?,?,?,?)";
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setInt(1, items);
		prepare.setString(2, username);
		prepare.setInt(3, password);
		prepare.setInt(4, productId);
		prepare.setString(5, productName);
		prepare.setInt(6, qty);
		prepare.setInt(7, price);
		prepare.setInt(8, totalPrice);
		int rows = prepare.executeUpdate();
		System.out.println("added:" + rows);

	}

	/*public static void delete(int items) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "delete from product where items=?";
		PreparedStatement prepare = connection.prepareStatement(query);
		System.out.println("deleted successfully");
		prepare.execute();
		connection.close();
	}*/

	public static void delete() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		String query = "delete from product where items=4";
		PreparedStatement prepare = connection.prepareStatement(query);
		System.out.println("deleted successfully");
		prepare.execute();
		connection.close();
	}
	
}
       
	


