package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/demo3";
		String userName = "root";
		String password = "ajith123";
		String query = "select * from product";
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsmd=rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		
	
		for(int i=1; i<=rsmd.getColumnCount(); i++)
		{
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		System.out.println();
		
		while(rs.next())
		{
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		
		System.out.println(connection);
		update();
		delete();
		insert();

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo3", "root", "ajith123");
		return connection;

	}

	public static void update() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "update product set username='ajith' where product_id=13";
		PreparedStatement prepare = connection.prepareStatement(query);
		System.out.println("Updated successfully");
		prepare.execute();
		connection.close();
	}

	public static void delete() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "delete from product where product_id=12";
		PreparedStatement prepare = connection.prepareStatement(query);
		System.out.println("deleted successfully");
		prepare.execute();
		connection.close();
	}

	public static void insert() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "insert into product values(1,'ajith',12654182,12,'apple',2,30,60)";
		PreparedStatement prepare = connection.prepareStatement(query);
		System.out.println("inserted successfully");
		prepare.execute();
		connection.close();
	}

}